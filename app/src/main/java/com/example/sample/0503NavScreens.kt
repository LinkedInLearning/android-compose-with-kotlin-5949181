package com.example.sample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.red30.R
import com.example.red30.compose.theme.Red30TechTheme
import com.example.red30.data.ConferenceRepository
import com.example.red30.data.SessionInfo
import com.example.red30.data.fake
import com.example.red30.data.fake2
import com.example.sample.FakeConferenceRepository

private const val TAG = "MainViewModel"

@Composable
private fun MainApp(modifier: Modifier = Modifier) {
    // This will use the koinViewModel function in practice
    val viewModel = MainViewModel2(conferenceRepository = FakeConferenceRepository())
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            ElevatedButton(
                onClick = {} //onBannerClick
            ) {
                Text(
                    text = stringResource(R.string.speakers_label),
                    style = MaterialTheme.typography.titleLarge,
                )
            }

            uiState.sessionInfos.forEach {
                Text(it.session.name)
            }
        }
    }
}

@Preview
@Composable
private fun AppPreview() {
    Red30TechTheme {
        MainApp()
    }
}

private class FakeConferenceRepository: ConferenceRepository {
    override suspend fun loadConferenceInfo(): List<SessionInfo> {
        return listOf(SessionInfo.fake(), SessionInfo.fake2())
    }

    override suspend fun toggleFavorite(sessionId: Int): List<Int> {
        TODO("Not yet implemented")
    }
}