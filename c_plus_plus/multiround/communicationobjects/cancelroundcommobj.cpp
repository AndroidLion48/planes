#include "cancelroundcommobj.h"

#include <QMessageBox>
#include "viewmodels/cancelroundviewmodel.h"
#include "multiplayerround.h"


bool CancelRoundCommObj::makeRequest()
{ 
    if (m_IsSinglePlayer) {
        //qDebug() << "makeRequestBasis in single player modus";
        return false;
    }
    if (m_GlobalData->m_UserData.m_UserName.isEmpty()) {
        if (m_ParentWidget != nullptr) { //nullptr is in tests
            QMessageBox msgBox(m_ParentWidget);
            msgBox.setText("No user logged in");
            msgBox.exec();
        }
        return false;
    }


    m_RequestData = prepareViewModel().toJson();
    
    makeRequestBasis(true);
    return true;
}

void CancelRoundCommObj::finishedRequest()
{
    QJsonObject retJson;
    if (!finishRequestHelper(retJson)) 
        return;

    m_MultiRound->setRoundCancelled();
    emit roundCancelled();
}

bool CancelRoundCommObj::validateReply(const QJsonObject& reply) {
    return (reply.contains("roundId"));
}

CancelRoundViewModel CancelRoundCommObj::prepareViewModel() {
    CancelRoundViewModel cancelRoundData;
    cancelRoundData.m_RoundId = m_GlobalData->m_GameData.m_RoundId;
    cancelRoundData.m_GameId = m_GlobalData->m_GameData.m_GameId;
    return cancelRoundData;
}