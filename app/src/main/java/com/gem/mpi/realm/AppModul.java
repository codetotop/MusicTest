package com.gem.mpi.realm;

import com.gem.mpi.realm.model.CompleteSurveyRealmObject;
import com.gem.mpi.realm.model.SurveyRealmObject;

import io.realm.annotations.RealmModule;

/**
 * Created by admin on 11/19/2017.
 * App realm Modul
 */

@RealmModule(classes = {SurveyRealmObject.class, CompleteSurveyRealmObject.class})

public class AppModul {
}
