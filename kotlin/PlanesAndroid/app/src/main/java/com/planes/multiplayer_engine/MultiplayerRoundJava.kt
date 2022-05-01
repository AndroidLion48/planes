package com.planes.multiplayer_engine

import androidx.core.util.Pair
import com.planes.android.MultiplayerRoundInterface
import com.planes.android.PlanesRoundInterface
import com.planes.multiplayer_engine.requests.CreateGameRequest
import com.planes.multiplayer_engine.requests.NoRobotRequest
import com.planes.multiplayer_engine.responses.*
import com.planes.single_player_engine.*
import io.reactivex.Observable
import retrofit2.Response

class MultiplayerRoundJava : MultiplayerRoundInterface {
    override fun createPlanesRound() {
        if (MultiplayerRoundJava.global_Round != null) return
        MultiplayerRoundJava.global_Round = MultiplayerRound(10,10, 3)
    }

    override fun testServerVersion(): Observable<Response<VersionResponse>> {
        return global_Round!!.testServerVersion()
    }

    override fun login(username: String, password: String): Observable<Response<LoginResponse>> {
        return global_Round!!.login(username, password)
    }

    override fun setUserData(username: String, password: String, authToken: String) {
        global_Round!!.setUserData(username, password, authToken)
    }

    override fun getGameId() : Long {
        return global_Round!!.getGameId()
    }

    override fun getRoundId() : Long {
        return global_Round!!.getRoundId()
    }

    override fun getUserId(): Long {
        return global_Round!!.getUserId()
    }

    override fun getOpponentId(): Long {
        return global_Round!!.getOpponentId()
    }

    override fun getUsername(): String {
        return global_Round!!.getUsername()
    }

    override  fun getOpponentName(): String {
        return global_Round!!.getOpponentName()
    }

    override fun register(username: String, password: String): Observable<Response<RegistrationResponse>> {
        return global_Round!!.register(username, password)
    }

    override fun setRegistrationResponse(regResp: RegistrationResponse) {
        global_Round!!.setRegistrationResponse(regResp)
    }

    override fun getRegistrationResponse(): RegistrationResponse {
        return global_Round!!.getRegistrationResponse()
    }

    override fun norobot(requestId: Long, answer: String): Observable<Response<NoRobotResponse>> {
        return global_Round!!.norobot(requestId, answer);
    }

    override fun isUserLoggedIn(): Boolean {
        return global_Round!!.isUserLoggedIn()
    }

    override fun refreshGameStatus(gameName: String):
            Observable<retrofit2.Response<GameStatusResponse>> {
        return global_Round!!.refreshGameStatus(gameName)
    }

    override fun createGame(gameName: String): Observable<retrofit2.Response<CreateGameResponse>> {
        return global_Round!!.createGame(gameName)
    }

    override fun setGameData(gameCreationResponse: CreateGameResponse) {
        return global_Round!!.setGameData(gameCreationResponse)
    }

    override fun setGameData(connectToGameResponse: ConnectToGameResponse) {
        return global_Round!!.setGameData(connectToGameResponse)
    }

    override fun setGameData(gameStatusResponse: GameStatusResponse) {
        return global_Round!!.setGameData(gameStatusResponse)
    }

    override fun setUserId(userid: Long) {
        return global_Round!!.setUserId(userid)
    }

    override fun connectToGame(gameName: String): Observable<retrofit2.Response<ConnectToGameResponse>> {
        return global_Round!!.connectToGame(gameName)
    }

    override fun resetGameData() {
        global_Round!!.resetGameData()
    }

    override fun getRowNo(): Int {
        return global_Round!!.getRowNo()
    }

    override fun getColNo(): Int {
        return global_Round!!.getColNo()
    }

    override fun getPlaneNo(): Int {
        return global_Round!!.getPlaneNo()
    }

    override fun getPlaneSquareType(i: Int, j: Int, isComputer: Int): Int {
        return global_Round!!.getPlaneSquareType(i, j, if (isComputer > 0) true else false)
    }

    //edit the board
    override fun movePlaneLeft(idx: Int): Int {
        return if (global_Round!!.movePlaneLeft(idx)) 1 else 0
    }

    override fun movePlaneRight(idx: Int): Int {
        return if (global_Round!!.movePlaneRight(idx)) 1 else 0
    }

    override fun movePlaneUpwards(idx: Int): Int {
        return if (global_Round!!.movePlaneUpwards(idx)) 1 else 0
    }

    override fun movePlaneDownwards(idx: Int): Int {
        return if (global_Round!!.movePlaneDownwards(idx)) 1 else 0
    }

    override fun rotatePlane(idx: Int): Int {
        return if (global_Round!!.rotatePlane(idx)) 1 else 0
    }

    override fun doneClicked() {
        global_Round!!.doneEditing()
    }

    override fun playerGuessAlreadyMade(row: Int, col: Int): Int {
        return global_Round!!.playerGuessAlreadyMade(row, col)
    }

    override fun playerGuess(row: Int, col: Int) {

    }

    override fun playerGuess(gp: GuessPoint): PlayerGuessReaction {
        return global_Round!!.playerGuess(gp)
    }

    fun playerGuessIncomplete(row: Int, col: Int): Pair<Type, PlayerGuessReaction> {
        return Pair(Type.Miss, PlayerGuessReaction())
    }

    override fun playerGuess_RoundEnds(): Boolean {
        return global_Player_Guess_Reaction.m_RoundEnds
    }

    override fun playerGuess_IsDraw(): Boolean {
        return global_Player_Guess_Reaction.m_IsDraw
    }

    override fun playerGuess_IsPlayerWinner(): Boolean {
        return global_Player_Guess_Reaction.m_isPlayerWinner
    }

    override fun playerGuess_ComputerMoveGenerated(): Boolean {
        return global_Player_Guess_Reaction.m_ComputerMoveGenerated
    }

    override fun playerGuess_StatNoPlayerMoves(): Int {
        return global_Player_Guess_Reaction.m_GameStats.playerMoves()
    }

    override fun playerGuess_StatNoPlayerHits(): Int {
        return global_Player_Guess_Reaction.m_GameStats.playerHits()
    }

    override fun playerGuess_StatNoPlayerMisses(): Int {
        return global_Player_Guess_Reaction.m_GameStats.playerMisses()
    }

    override fun playerGuess_StatNoPlayerDead(): Int {
        return global_Player_Guess_Reaction.m_GameStats.playerDead()
    }

    override fun playerGuess_StatNoPlayerWins(): Int {
        return global_Player_Guess_Reaction.m_GameStats.playerWins()
    }

    override fun playerGuess_StatNoComputerMoves(): Int {
        return global_Player_Guess_Reaction.m_GameStats.computerMoves()
    }

    override fun playerGuess_StatNoComputerHits(): Int {
        return global_Player_Guess_Reaction.m_GameStats.computerHits()
    }

    override fun playerGuess_StatNoComputerMisses(): Int {
        return global_Player_Guess_Reaction.m_GameStats.computerMisses()
    }

    override fun playerGuess_StatNoComputerDead(): Int {
        return global_Player_Guess_Reaction.m_GameStats.computerDead()
    }

    override fun playerGuess_StatNoComputerWins(): Int {
        return global_Player_Guess_Reaction.m_GameStats.computerWins()
    }

    override fun playerGuess_StatNoDraws(): Int {
        return global_Player_Guess_Reaction.m_GameStats.draws()
    }

    override fun roundEnds() {
        global_Round!!.setRoundEnd()
    }

    override fun initRound() {
        global_Round!!.initRound()
    }

    override fun getPlayerGuessesNo(): Int {
        return global_Round!!.getPlayerGuessesNo()
    }

    override fun getPlayerGuessRow(idx: Int): Int {
        return global_Round!!.getPlayerGuess(idx).row()
    }

    override fun getPlayerGuessCol(idx: Int): Int {
        return global_Round!!.getPlayerGuess(idx).col()
    }

    override fun getPlayerGuessType(idx: Int): Int {
        return global_Round!!.getPlayerGuess(idx).type().value
    }

    override fun getComputerGuessesNo(): Int {
        return global_Round!!.getComputerGuessesNo()
    }

    override fun getComputerGuessRow(idx: Int): Int {
        return global_Round!!.getComputerGuess(idx).row()
    }

    override fun getComputerGuessCol(idx: Int): Int {
        return global_Round!!.getComputerGuess(idx).col()
    }

    override fun getComputerGuessType(idx: Int): Int {
        return global_Round!!.getComputerGuess(idx).type().value
    }

    override fun getGameStage(): Int {
        return global_Round!!.getCurrentStage()
    }

    override fun setComputerSkill(skill: Int): Boolean {
        return true
    }

    override fun setShowPlaneAfterKill(show: Boolean): Boolean {
        return true
    }

    override fun getComputerSkill(): Int {
        return 0
    }

    override fun getShowPlaneAfterKill(): Boolean {
        return true
    }

    companion object {
        private var global_Round: MultiplayerRound? = null
        private var global_Guess_Result = Type.Miss
        private var global_Player_Guess_Reaction = PlayerGuessReaction()
    }
}