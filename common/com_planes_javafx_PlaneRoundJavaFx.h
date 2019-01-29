/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_planes_javafx_PlaneRoundJavaFx */

#ifndef _Included_com_planes_javafx_PlaneRoundJavaFx
#define _Included_com_planes_javafx_PlaneRoundJavaFx
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    createPlanesRound
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_createPlanesRound
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    getRowNo
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_getRowNo
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    getColNo
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_getColNo
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    getPlaneNo
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_getPlaneNo
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    getPlaneSquareType
 * Signature: (IIZ)I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_getPlaneSquareType
  (JNIEnv *, jobject, jint, jint, jboolean);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    movePlaneLeft
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_movePlaneLeft
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    movePlaneRight
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_movePlaneRight
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    movePlaneUpwards
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_movePlaneUpwards
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    movePlaneDownwards
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_movePlaneDownwards
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    rotatePlane
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_rotatePlane
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    doneClicked
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_doneClicked
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_Res
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1Res
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_RoundEnds
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1RoundEnds
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_IsPlayerWinner
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1IsPlayerWinner
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_ComputerMoveGenerated
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1ComputerMoveGenerated
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_ComputerMoveRow
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1ComputerMoveRow
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_ComputerMoveCol
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1ComputerMoveCol
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_ComputerMoveRes
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1ComputerMoveRes
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_StatNoPlayerMoves
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1StatNoPlayerMoves
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_StatNoPlayerHits
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1StatNoPlayerHits
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_StatNoPlayerMisses
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1StatNoPlayerMisses
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_StatNoPlayerDead
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1StatNoPlayerDead
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_StatNoPlayerWins
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1StatNoPlayerWins
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_StatNoComputerMoves
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1StatNoComputerMoves
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_StatNoComputerHits
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1StatNoComputerHits
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_StatNoComputerMisses
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1StatNoComputerMisses
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_StatNoComputerDead
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1StatNoComputerDead
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    playerGuess_StatNoComputerWins
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_playerGuess_1StatNoComputerWins
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    roundEnds
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_roundEnds
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    getPlayerGuessesNo
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_getPlayerGuessesNo
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    getPlayerGuessRow
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_getPlayerGuessRow
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    getPlayerGuessCol
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_getPlayerGuessCol
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    getPlayerGuessType
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_getPlayerGuessType
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    getComputerGuessesNo
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_getComputerGuessesNo
  (JNIEnv *, jobject);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    getComputerGuessRow
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_getComputerGuessRow
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    getComputerGuessCol
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_getComputerGuessCol
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_planes_javafx_PlaneRoundJavaFx
 * Method:    getComputerGuessType
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_planes_javafx_PlaneRoundJavaFx_getComputerGuessType
  (JNIEnv *, jobject, jint);

#ifdef __cplusplus
}
#endif
#endif
