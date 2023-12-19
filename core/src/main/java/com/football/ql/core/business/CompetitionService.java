package com.football.ql.core.business;

import com.football.ql.core.exception.CoreException;
import com.football.ql.core.exception.model.ErrorMessage;
import com.football.ql.core.model.Competition;
import com.football.ql.core.port.persistence.CompetitionPersistenceAdapter;
import com.football.ql.core.port.persistence.SyncCompetitionPersistenceAdapter;
import com.football.ql.core.port.service.CompetitionServiceAdapter;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class CompetitionService implements CompetitionServiceAdapter {

    private final SyncCompetitionPersistenceAdapter syncCompetition;
    private final CompetitionPersistenceAdapter persist;

    @Override
    public Competition syncCompetition(String leagueCode) {
        var syncedInfo = syncCompetition.syncCompetition(leagueCode);

        if (syncedInfo != null) {
            return persist.saveCompetition(syncedInfo);
        }

        throw new CoreException(ErrorMessage.PERSIST_ERROR.getCode(), ErrorMessage.PERSIST_ERROR.getMessage());
    }
}
