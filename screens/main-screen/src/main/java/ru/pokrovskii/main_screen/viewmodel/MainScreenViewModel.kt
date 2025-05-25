package ru.pokrovskii.main_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.pokrovskii.auth.api.UserCenter
import ru.pokrovskii.main_screen.domain.MainScreenCenter
import ru.pokrovskii.main_screen.state.MainScreenState
import ru.pokrovskii.main_screen.state.converter.toLandingBlockState

internal class MainScreenViewModel(
    private val center: MainScreenCenter,
    userCenterLazy: Lazy<UserCenter>,
) : ViewModel() {

    private val userCenter by userCenterLazy
    private var loadJob: Job? = null

    private val _state = MutableStateFlow<MainScreenState>(MainScreenState.Loading)
    val state: StateFlow<MainScreenState> = _state

    val canEdit = userCenter
        .users
        .map { user ->
            user?.isAdmin ?: false
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = userCenter.currentUserBlocking()?.isAdmin ?: false,
        )

    init {
        loadJob = viewModelScope.launch {
            loadLanding()
        }
    }

    fun onRetryClick() {
        _state.value = MainScreenState.Loading
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            loadLanding()
        }
    }

    fun onSongDelete(id: Int, blockId: String) {
        _state.value = MainScreenState.Loading
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            val result = center.deleteSong(
                blockId = blockId,
                id = id,
            )

            _state.value = if (result == null) {
                MainScreenState.Error
            } else {
                MainScreenState.Success(
                    blocks = result.map { it.toLandingBlockState(canEdit = canEdit.value) },
                )
            }
        }
    }

    fun onBlockTitleChanged(id: String, newTitle: String) {
        _state.value = MainScreenState.Loading
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            val result = center.changeTitle(
                blockId = id,
                newTitle = newTitle,
            )

            _state.value = if (result == null) {
                MainScreenState.Error
            } else {
                MainScreenState.Success(
                    blocks = result.map { it.toLandingBlockState(canEdit = canEdit.value) },
                )
            }
        }
    }

    fun onSongAdd(
        id: Int,
        title: String,
        artist: String,
        imageUrl: String,
        blockId: String,
    ) {
        _state.value = MainScreenState.Loading
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            val result = center.addSong(
                id = id,
                blockId = blockId,
                title = title,
                artist = artist,
                imageUrl = imageUrl,
            )

            _state.value = if (result == null) {
                MainScreenState.Error
            } else {
                MainScreenState.Success(
                    blocks = result.map { it.toLandingBlockState(canEdit = canEdit.value) },
                )
            }
        }
    }

    fun onBlockAdd() {
        _state.value = MainScreenState.Loading
        loadJob?.cancel()
        loadJob = viewModelScope.launch {
            val result = center.addBlock()

            _state.value = if (result == null) {
                MainScreenState.Error
            } else {
                MainScreenState.Success(
                    blocks = result.map { it.toLandingBlockState(canEdit = canEdit.value) },
                )
            }
        }
    }

    private suspend fun loadLanding() {
        val result = center.loadLanding()
        _state.value = if (result == null) {
            MainScreenState.Error
        } else {
            MainScreenState.Success(
                blocks = result.map { it.toLandingBlockState(canEdit = canEdit.value) },
            )
        }
    }
}