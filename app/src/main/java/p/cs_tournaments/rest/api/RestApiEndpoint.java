package p.cs_tournaments.rest.api;

import android.content.Context;

import p.cs_tournaments.R;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class RestApiEndpoint {

        private static RestApi apiInstance;

        private RestApiEndpoint() {

        }

        public synchronized static RestApi getApiInstance(Context context) {
            if (apiInstance == null) {
                final String baseUrl = context.getApplicationContext()
                        .getResources().getString(R.string.server_url);

                final Retrofit builder = new Retrofit.Builder().baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create()).build();

                apiInstance = builder.create(RestApi.class);
            }

            return apiInstance;
        }
}
