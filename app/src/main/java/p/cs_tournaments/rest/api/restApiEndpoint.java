package p.cs_tournaments.rest.api;

import android.content.Context;

import p.cs_tournaments.R;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class restApiEndpoint {

        private static restApi apiInstance;

        private restApiEndpoint() {

        }

        public synchronized static restApi getApiInstance(Context context) {
            if (apiInstance == null) {
                final String baseUrl = context.getApplicationContext()
                        .getResources().getString(R.string.fmf_server_url);

                final Retrofit builder = new Retrofit.Builder().baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create()).build();

                apiInstance = builder.create(restApi.class);
            }

            return apiInstance;
        }
}
