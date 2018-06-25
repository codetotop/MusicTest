package com.gem.mpi.realm;

import io.realm.Realm;

/**
 * Created by admin on 11/19/2017.
 * RealmController
 */

public class RealmController {
  private static volatile RealmController mInstance;
  private final Realm mRealm;

  private RealmController() {
    mRealm = Realm.getDefaultInstance();
  }

  public synchronized static RealmController getInstance() {
    if (mInstance == null) {
      mInstance = new RealmController();
    }
    return mInstance;
  }

  public Realm getRealm() {
    return mRealm;
  }

  // Refresh the realm instance
  public void refresh() {
    mRealm.refresh();
  }
}
