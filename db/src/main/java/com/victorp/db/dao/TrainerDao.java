package com.victorp.db.dao;

import com.victorp.model.Trainer;

public interface TrainerDao extends GeneralDao<Trainer> {
    Trainer getByLogin(String login) throws Exception;

    Trainer getByGroup(String group) throws Exception;

}
