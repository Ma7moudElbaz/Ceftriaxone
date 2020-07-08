package com.cat.ceftriaxone;

import android.content.Context;

public class SideNavigationHandler {
    Context context;
    int clickedItemId;

    public SideNavigationHandler(Context context, int clickedItemId) {
        this.context = context;
        this.clickedItemId=clickedItemId;
    }

    public void navigate(){

        if (clickedItemId == R.id.nav_speciality) {


        } else if (clickedItemId == R.id.nav_indications) {


        } else if (clickedItemId == R.id.nav_products) {


        } else if (clickedItemId == R.id.nav_population) {


        } else if (clickedItemId == R.id.nav_contraindications) {


        } else if (clickedItemId == R.id.nav_tips) {


        }else if (clickedItemId == R.id.nav_pi) {


        }
    }

}
