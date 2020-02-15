package com.planes.android;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.planes.javafx.PlaneRoundJavaFx;



public class GameControlsAdaptor {

    public GameControlsAdaptor(Context context) {
        m_Context = context;
    }

    public void setBoardEditingControls(Button upButton, Button downButton, Button leftButton, Button rightButton, Button doneButton, Button rotateButton) {
        m_UpButton = upButton;
        m_DownButton = downButton;
        m_LeftButton = leftButton;
        m_RightButton = rightButton;
        m_DoneButton = doneButton;
        m_RotateButton = rotateButton;

        if (m_LeftButton != null) {
            m_LeftButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                m_GameBoards.movePlaneLeft();
                }
            });
        }

        if (m_RightButton != null) {
            m_RightButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                m_GameBoards.movePlaneRight();
                }
            });
        }

        if (m_UpButton != null) {
            m_UpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                m_GameBoards.movePlaneUp();
                }
            });
        }

        if (m_DownButton != null) {
            m_DownButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                m_GameBoards.movePlaneDown();
                }
            });
        }

        if (m_RotateButton != null) {
            m_RotateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                m_GameBoards.rotatePlane();
                }
            });
        }

        if (m_DoneButton != null) {
            m_DoneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                m_PlanesLayout.setGameStage();
                setGameStage();
                m_GameBoards.setGameStage();
                m_PlaneRound.doneClicked();
                }
            });
        }
    }

    public void setGameControls(TwoLineTextButtonWithState viewComputerBoardButton1, ColouredSurfaceWithText movesLabel, ColouredSurfaceWithText movesCount, ColouredSurfaceWithText missesLabel, ColouredSurfaceWithText missesCount,
                                ColouredSurfaceWithText hitsLabel, ColouredSurfaceWithText hitsCount, ColouredSurfaceWithText deadsLabel, ColouredSurfaceWithText deadCount) {
        m_ViewComputerBoardButton1 = viewComputerBoardButton1;
        m_MovesLabel = movesLabel;
        m_MovesTextView = movesCount;
        m_MissesLabel = missesLabel;
        m_MissesTextView = missesCount;
        m_HitsLabel = hitsLabel;
        m_HitsTextView = hitsCount;
        m_DeadLabel = deadsLabel;
        m_DeadTextView = deadCount;

        m_ViewComputerBoardButton1.setState("player");


        if (m_ViewComputerBoardButton1 != null) {
            m_ViewComputerBoardButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (m_ViewComputerBoardButton1.getCurrentStateName() == "computer") {
                        m_GameBoards.setComputerBoard();
                        m_PlanesLayout.setComputerBoard();
                        m_ViewComputerBoardButton1.setState("player");
                        int misses = m_PlaneRound.playerGuess_StatNoPlayerMisses();
                        int hits = m_PlaneRound.playerGuess_StatNoPlayerHits();
                        int dead = m_PlaneRound.playerGuess_StatNoPlayerDead();
                        int moves = m_PlaneRound.playerGuess_StatNoPlayerMoves();
                        m_MissesTextView.setText(Integer.toString(misses));
                        m_HitsTextView.setText(Integer.toString(hits));
                        m_DeadTextView.setText(Integer.toString(dead));
                        m_MovesTextView.setText(Integer.toString(moves));
                    } else if (m_ViewComputerBoardButton1.getCurrentStateName() == "player") {
                        m_GameBoards.setPlayerBoard();
                        m_PlanesLayout.setPlayerBoard();
                        m_ViewComputerBoardButton1.setState("computer");
                        int misses = m_PlaneRound.playerGuess_StatNoComputerMisses();
                        int hits = m_PlaneRound.playerGuess_StatNoComputerHits();
                        int dead = m_PlaneRound.playerGuess_StatNoComputerDead();
                        int moves = m_PlaneRound.playerGuess_StatNoComputerMoves();
                        m_MissesTextView.setText(Integer.toString(misses));
                        m_HitsTextView.setText(Integer.toString(hits));
                        m_DeadTextView.setText(Integer.toString(dead));
                        m_MovesTextView.setText(Integer.toString(moves));
                    }
                }
            });
        }
    }

    public void setStartNewGameControls(TwoLineTextButtonWithState viewComputerBoardButton2, TwoLineTextButton startNewGameButton,
                                        ColouredSurfaceWithText computerWinsLabel, ColouredSurfaceWithText computerWinsCount, ColouredSurfaceWithText playerWinsLabel, ColouredSurfaceWithText playerWinsCount, ColouredSurfaceWithText winnerText ) {
        m_ViewComputerBoardButton2 = viewComputerBoardButton2;
        m_StartNewRound = startNewGameButton;
        m_ComputerWinsLabel = computerWinsLabel;
        m_ComputerWins = computerWinsCount;
        m_PlayerWinsLabel = playerWinsLabel;
        m_PlayerWins = playerWinsCount;
        m_WinnerTextView = winnerText;

        if (m_StartNewRound != null) {
            m_StartNewRound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                m_PlaneRound.initRound();
                m_PlanesLayout.setBoardEditingStage();
                m_GameBoards.setBoardEditingStage();
                setBoardEditingStage();
                }
            });
        }

        m_ViewComputerBoardButton2.setState("player");

        if (m_ViewComputerBoardButton2 != null) {
            m_ViewComputerBoardButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (m_ViewComputerBoardButton2.getCurrentStateName() == "computer") {
                        m_GameBoards.setComputerBoard();
                        m_PlanesLayout.setComputerBoard();
                        m_ViewComputerBoardButton2.setState("player");
                    } else if (m_ViewComputerBoardButton2.getCurrentStateName() == "player") {
                        m_GameBoards.setPlayerBoard();
                        m_PlanesLayout.setPlayerBoard();
                        m_ViewComputerBoardButton2.setState("computer");
                    }
                }
            });
        }
    }

    public void setNewRoundStage() {
        int computer_wins = m_PlaneRound.playerGuess_StatNoComputerWins();
        int player_wins = m_PlaneRound.playerGuess_StatNoPlayerWins();
        m_PlayerWins.setText(Integer.toString(player_wins));
        m_ComputerWins.setText(Integer.toString(computer_wins));
        m_PlanesLayout.setPlayerBoard();
    }

    public void setGameStage() {

        if (!m_Tablet) {
            m_GameBoards.setComputerBoard();
            m_ViewComputerBoardButton1.setState("player");
            updateStats(true);
        } else {
        }
    }

    public void setBoardEditingStage() {

    }


    public void updateStats(boolean isComputer) {
        if (isComputer) {
            int misses = m_PlaneRound.playerGuess_StatNoPlayerMisses();
            int hits = m_PlaneRound.playerGuess_StatNoPlayerHits();
            int dead = m_PlaneRound.playerGuess_StatNoPlayerDead();
            int moves = m_PlaneRound.playerGuess_StatNoPlayerMoves();
            m_MissesTextView.setText(Integer.toString(misses));
            m_HitsTextView.setText(Integer.toString(hits));
            m_DeadTextView.setText(Integer.toString(dead));
            m_MovesTextView.setText(Integer.toString(moves));
        } else {
            int misses = m_PlaneRound.playerGuess_StatNoComputerMisses();
            int hits = m_PlaneRound.playerGuess_StatNoComputerHits();
            int dead = m_PlaneRound.playerGuess_StatNoComputerDead();
            int moves = m_PlaneRound.playerGuess_StatNoComputerMoves();
            m_MissesTextView.setText(Integer.toString(misses));
            m_HitsTextView.setText(Integer.toString(hits));
            m_DeadTextView.setText(Integer.toString(dead));
            m_MovesTextView.setText(Integer.toString(moves));
        }
    }

    public void roundEnds(int playerWins, int computerWins, boolean isComputerWinner) {
        //TODO: do I need to update layout and game boards as well?
        setNewRoundStage();
        m_PlanesLayout.setComputerBoard();
        m_PlanesLayout.setNewRoundStage();
        if (isComputerWinner)
            m_WinnerTextView.setText(m_Context.getResources().getText(R.string.computer_winner).toString());
        else
            m_WinnerTextView.setText(m_Context.getResources().getText(R.string.player_winner).toString());

        int computer_wins = m_PlaneRound.playerGuess_StatNoComputerWins();
        int player_wins = m_PlaneRound.playerGuess_StatNoPlayerWins();
        m_PlayerWins.setText(Integer.toString(player_wins));
        m_ComputerWins.setText(Integer.toString(computer_wins));
    }

    public void setDoneEnabled(boolean enabled) {
        m_DoneButton.setEnabled(enabled);
    }

    public void setGameSettings(PlaneRoundJavaFx planeRound, boolean isTablet) {
        m_PlaneRound = planeRound;
        m_Tablet = isTablet;
    }

    public void setGameBoards(GameBoardsAdaptor gameBoards) {
        m_GameBoards = gameBoards;
    }

    public void setPlanesLayout(PlanesVerticalLayout planesLayout) { m_PlanesLayout = planesLayout; }

    private Context m_Context;
    private GameStages m_CurStage = GameStages.BoardEditing;
    private PlaneRoundJavaFx m_PlaneRound;
    private GameBoardsAdaptor m_GameBoards;
    private boolean m_Tablet = false;
    private PlanesVerticalLayout m_PlanesLayout = null;

    //Board Editing
    private Button m_RotateButton;
    private Button m_LeftButton;
    private Button m_RightButton;
    private Button m_UpButton;
    private Button m_DownButton;
    private Button m_DoneButton;

    //Game
    private ColouredSurfaceWithText m_HitsTextView;
    private ColouredSurfaceWithText m_MissesTextView;
    private ColouredSurfaceWithText m_DeadTextView;
    private ColouredSurfaceWithText m_MovesTextView;
    private ColouredSurfaceWithText m_HitsLabel;
    private ColouredSurfaceWithText m_MissesLabel;
    private ColouredSurfaceWithText m_DeadLabel;
    private ColouredSurfaceWithText m_MovesLabel;
    private TwoLineTextButtonWithState m_ViewComputerBoardButton1;

    //Start New Game
    private ColouredSurfaceWithText m_WinnerTextView;
    private TwoLineTextButton m_StartNewRound;
    private ColouredSurfaceWithText m_ComputerWins;
    private ColouredSurfaceWithText m_PlayerWins;
    private ColouredSurfaceWithText m_ComputerWinsLabel;
    private ColouredSurfaceWithText m_PlayerWinsLabel;
    private TwoLineTextButtonWithState m_ViewComputerBoardButton2;
}
