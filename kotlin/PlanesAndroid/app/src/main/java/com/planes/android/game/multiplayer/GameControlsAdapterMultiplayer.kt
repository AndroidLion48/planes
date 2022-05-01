package com.planes.android.game.singleplayer

import android.content.Context
import android.widget.Button
import android.widget.ProgressBar
import com.planes.android.*
import com.planes.android.customviews.ColouredSurfaceWithText
import com.planes.android.customviews.ColouredSurfaceWithTwoLineText
import com.planes.android.customviews.TwoLineTextButton
import com.planes.android.customviews.TwoLineTextButtonWithState
import com.planes.android.game.multiplayer.GameBoardsAdapterMultiplayer
import com.planes.single_player_engine.GameStages

class GameControlsAdapterMultiplayer(private val m_Context: Context) {
    private val m_CurStage = GameStages.BoardEditing
    private lateinit var m_MultiplayerRound: MultiplayerRoundInterface
    private lateinit var m_GameBoards: GameBoardsAdapterMultiplayer
    private var m_Tablet = false
    private lateinit var m_PlanesLayout: PlanesVerticalLayoutSinglePlayer

    //Board Editing
    private lateinit var m_RotateButton: Button
    private lateinit var m_DoneButton: Button
    private lateinit var m_CancelBoardEditingButton: Button
    private lateinit var m_ProgressBarBoardEditing: ProgressBar

    //Game
    private lateinit var m_GameStats: TwoLineTextButton
    private lateinit var m_ViewOpponentBoardButton1: TwoLineTextButtonWithState
    private lateinit var m_CancelGameButton: Button
    private lateinit var m_ProgressBarGame: ProgressBar

    //Start New Game
    private lateinit var m_WinnerTextView: ColouredSurfaceWithText
    private lateinit var m_StartNewRound: TwoLineTextButton
    private lateinit var m_ComputerWins: ColouredSurfaceWithText
    private lateinit var m_PlayerWins: ColouredSurfaceWithText
    private lateinit var m_Draws: ColouredSurfaceWithText
    private lateinit var m_ComputerWinsLabel: ColouredSurfaceWithText
    private lateinit var m_PlayerWinsLabel: ColouredSurfaceWithText
    private lateinit var m_DrawsLabel: ColouredSurfaceWithText
    private lateinit var m_ViewComputerBoardButton2: TwoLineTextButtonWithState

    fun setBoardEditingControls(doneButton: Button, rotateButton: Button, cancelButton: Button, progressBar: ProgressBar) {
        m_DoneButton = doneButton
        m_RotateButton = rotateButton
        m_CancelBoardEditingButton = cancelButton
        m_ProgressBarBoardEditing = progressBar

        if (this::m_RotateButton.isInitialized) {
            m_RotateButton.setOnClickListener { m_GameBoards.rotatePlane() }
        }
        if (this::m_DoneButton.isInitialized) {
            m_DoneButton.setOnClickListener {
                setGameStage()
                m_PlanesLayout.setGameStage()
                m_GameBoards.setGameStage()
                m_MultiplayerRound.doneClicked()
            }
        }

        //TODO: cancel method
    }

    fun setGameControls(gameStats: TwoLineTextButton, viewOpponentBoard: TwoLineTextButtonWithState, cancelButton: Button, progressBar: ProgressBar) {
        m_GameStats = gameStats
        m_ViewOpponentBoardButton1 = viewOpponentBoard
        m_CancelGameButton = cancelButton
        m_ProgressBarGame = progressBar

        m_ViewOpponentBoardButton1.setState("player", m_Context.resources.getString(R.string.view_player_board2))
        if (this::m_ViewOpponentBoardButton1.isInitialized) {
            m_ViewOpponentBoardButton1.setOnClickListener {
                if (m_ViewOpponentBoardButton1.currentStateName === "computer") {
                    m_GameBoards.setComputerBoard()
                    m_ViewOpponentBoardButton1.setState("player", m_Context.resources.getString(R.string.view_player_board2))
                    m_PlanesLayout.setComputerBoard()
                } else if (m_ViewOpponentBoardButton1.currentStateName === "player") {
                    m_GameBoards.setPlayerBoard()
                    m_ViewOpponentBoardButton1.setState("computer", m_Context.resources.getString(R.string.view_computer_board2))
                    m_PlanesLayout.setPlayerBoard()
                }
            }
        }
    }

    fun setStartNewGameControls(viewComputerBoardButton2: TwoLineTextButtonWithState, startNewGameButton: TwoLineTextButton,
                                computerWinsLabel: ColouredSurfaceWithText, computerWinsCount: ColouredSurfaceWithText,
                                playerWinsLabel: ColouredSurfaceWithText, playerWinsCount: ColouredSurfaceWithText,
                                drawsLabel: ColouredSurfaceWithText, drawsCount: ColouredSurfaceWithText, winnerText: ColouredSurfaceWithText
    ) {
        m_ViewComputerBoardButton2 = viewComputerBoardButton2
        m_StartNewRound = startNewGameButton
        m_ComputerWinsLabel = computerWinsLabel
        m_ComputerWins = computerWinsCount
        m_PlayerWinsLabel = playerWinsLabel
        m_PlayerWins = playerWinsCount
        m_WinnerTextView = winnerText
        m_Draws = drawsCount
        m_DrawsLabel = drawsLabel
        if (this::m_StartNewRound.isInitialized != null) {
            m_StartNewRound.setOnClickListener {
                m_MultiplayerRound.initRound()
                m_PlanesLayout.setBoardEditingStage()
                m_GameBoards.setBoardEditingStage()
                setBoardEditingStage()
            }
        }
        m_ViewComputerBoardButton2.setState("player", m_Context.resources.getString(R.string.view_player_board2))
        if (this::m_ViewComputerBoardButton2.isInitialized) {
            m_ViewComputerBoardButton2.setOnClickListener {
                if (m_ViewComputerBoardButton2.currentStateName === "computer") {
                    m_GameBoards.setComputerBoard()
                    m_PlanesLayout.setComputerBoard()
                    m_ViewComputerBoardButton2.setState("player", m_Context.resources.getString(R.string.view_player_board2))
                } else if (m_ViewComputerBoardButton2.currentStateName === "player") {
                    m_GameBoards.setPlayerBoard()
                    m_PlanesLayout.setPlayerBoard()
                    m_ViewComputerBoardButton2.setState("computer", m_Context.resources.getString(R.string.view_computer_board2))
                }
            }
        }
    }

    fun setNewRoundStage() {
        val computer_wins = m_MultiplayerRound.playerGuess_StatNoComputerWins()
        val player_wins = m_MultiplayerRound.playerGuess_StatNoPlayerWins()
        val draws = m_MultiplayerRound.playerGuess_StatNoDraws()
        m_PlayerWins.setText(Integer.toString(player_wins))
        m_ComputerWins.setText(Integer.toString(computer_wins))
        m_Draws.setText(Integer.toString(draws))
        m_ViewComputerBoardButton2.setState("player", m_Context.resources.getString(R.string.view_player_board2))
        m_PlanesLayout.setComputerBoard()
    }

    fun setGameStage() {
        if (!m_Tablet) {
            m_GameBoards.setComputerBoard()
            m_ViewOpponentBoardButton1.setState("player", m_Context.resources.getString(R.string.view_player_board2))
            //updateStats(true) //TODO: do I need this ?
        } else {
        }
    }

    fun setBoardEditingStage() {}
    /*fun updateStats(isComputer: Boolean) {

        //on the computer board show the computer stats and
        //such that the player knows how far the computer is
        if (isComputer) {
            val misses = m_PlaneRound.playerGuess_StatNoComputerMisses()
            val hits = m_PlaneRound.playerGuess_StatNoComputerHits()
            val dead = m_PlaneRound.playerGuess_StatNoComputerDead()
            val moves = m_PlaneRound.playerGuess_StatNoComputerMoves()
            m_MissesTextView.setText(Integer.toString(misses))
            m_HitsTextView.setText(Integer.toString(hits))
            m_DeadTextView.setText(Integer.toString(dead))
            m_MovesTextView.setText(Integer.toString(moves))
        } else {
            val misses = m_PlaneRound.playerGuess_StatNoPlayerMisses()
            val hits = m_PlaneRound.playerGuess_StatNoPlayerHits()
            val dead = m_PlaneRound.playerGuess_StatNoPlayerDead()
            val moves = m_PlaneRound.playerGuess_StatNoPlayerMoves()
            m_MissesTextView.setText(Integer.toString(misses))
            m_HitsTextView.setText(Integer.toString(hits))
            m_DeadTextView.setText(Integer.toString(dead))
            m_MovesTextView.setText(Integer.toString(moves))
        }
    }*/

    fun roundEnds(isComputerWinner: Boolean, isDraw: Boolean) {
        m_PlanesLayout.setComputerBoard()
        m_PlanesLayout.setNewRoundStage()
        if (isComputerWinner) m_WinnerTextView.setText(m_Context.resources.getText(R.string.computer_winner).toString()) else m_WinnerTextView.setText(m_Context.resources.getText(
            R.string.player_winner
        ).toString())
        if (isDraw) m_WinnerTextView.setText(m_Context.resources.getText(R.string.draw_result).toString())
        val computer_wins = m_MultiplayerRound.playerGuess_StatNoComputerWins()
        val player_wins = m_MultiplayerRound.playerGuess_StatNoPlayerWins()
        val draws = m_MultiplayerRound.playerGuess_StatNoDraws()
        m_PlayerWins.setText(Integer.toString(player_wins))
        m_ComputerWins.setText(Integer.toString(computer_wins))
        m_Draws.setText(Integer.toString(draws))
        m_ViewComputerBoardButton2.setState("player", m_Context.resources.getText(R.string.view_player_board2).toString())
    }

    fun setDoneEnabled(enabled: Boolean) {
        m_DoneButton.isEnabled = enabled
    }

    fun setGameSettings(planeRound: MultiplayerRoundInterface, isTablet: Boolean) {
        m_MultiplayerRound = planeRound
        m_Tablet = isTablet
    }

    fun setGameBoards(gameBoards: GameBoardsAdapterMultiplayer) {
        m_GameBoards = gameBoards
    }

    fun setPlanesLayout(planesLayout: PlanesVerticalLayoutSinglePlayer) {
        m_PlanesLayout = planesLayout
    }
}