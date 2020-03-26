package com.morfin.myapplication;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmHelper {
    Realm realm;

    public RealmHelper(Realm realm){
        this.realm = realm;
    }

    //save
    public void save(final ContactModel contactModel){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.e("Terbuat", "Kontak Tersimpan");
                    Number currentIdNum = realm.where(ContactModel.class).max("id");
                    int nextId;
                    if (currentIdNum == null){
                        nextId = 1;
                    }else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    contactModel.setId(nextId);
                    ContactModel model = realm.copyToRealm(contactModel);
                }else {
                    Log.e("Error","Kontak Tak Tersimpan");
                }
            }
        });
    }
    //panggil data
    public List<ContactModel> getAllContact(){
        RealmResults<ContactModel> results = realm.where(ContactModel.class).findAll();
        return results;
    }

    //update
    public void update(final Integer id, final String nama, final Integer nomor){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ContactModel model = realm.where(ContactModel.class)
                        .equalTo("id", id)
                        .findFirst();
                model.setNama(nama);
                model.setNomor(nomor);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("Message", "Update Berhasil");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }
    //hapus data
    public void delete(Integer id){
        final RealmResults<ContactModel> model = realm.where(ContactModel.class).equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteFromRealm(0);
            }
        });
    }
}
