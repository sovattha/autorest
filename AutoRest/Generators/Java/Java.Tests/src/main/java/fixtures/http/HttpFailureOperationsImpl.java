/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package fixtures.http;

import com.google.common.reflect.TypeToken;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.ServiceResponseBuilder;
import com.microsoft.rest.ServiceResponseCallback;
import fixtures.http.models.ErrorException;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * An instance of this class provides access to all the operations defined
 * in HttpFailureOperations.
 */
public final class HttpFailureOperationsImpl implements HttpFailureOperations {
    /** The Retrofit service to perform REST calls. */
    private HttpFailureService service;
    /** The service client containing this operation class. */
    private AutoRestHttpInfrastructureTestService client;

    /**
     * Initializes an instance of HttpFailureOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public HttpFailureOperationsImpl(Retrofit retrofit, AutoRestHttpInfrastructureTestService client) {
        this.service = retrofit.create(HttpFailureService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for HttpFailureOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface HttpFailureService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("http/failure/emptybody/error")
        Call<ResponseBody> getEmptyError();

    }

    /**
     * Get empty error form server.
     *
     * @throws ErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @return the Boolean object wrapped in {@link ServiceResponse} if successful.
     */
    public ServiceResponse<Boolean> getEmptyError() throws ErrorException, IOException {
        Call<ResponseBody> call = service.getEmptyError();
        return getEmptyErrorDelegate(call.execute());
    }

    /**
     * Get empty error form server.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    public ServiceCall getEmptyErrorAsync(final ServiceCallback<Boolean> serviceCallback) {
        Call<ResponseBody> call = service.getEmptyError();
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Boolean>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getEmptyErrorDelegate(response));
                } catch (ErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponse<Boolean> getEmptyErrorDelegate(Response<ResponseBody> response) throws ErrorException, IOException {
        return new ServiceResponseBuilder<Boolean, ErrorException>()
                .register(200, new TypeToken<Boolean>() { }.getType())
                .registerError(ErrorException.class)
                .build(response);
    }

}
