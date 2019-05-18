import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class HttpClient {
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:8765/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build();
    private HttpRepository repository = retrofit.create(HttpRepository.class);

    public HttpClient(){

    }

    public ResponseData<List<User>> getUsers() throws IOException {
        Call<ResponseData<List<User>>> call = repository.getUsers();
        Response<ResponseData<List<User>>> response = call.execute();
        ResponseData<List<User>> responseData = response.body();
        return responseData;
    }

}
