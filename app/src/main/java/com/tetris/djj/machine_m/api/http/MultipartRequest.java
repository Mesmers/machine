package com.tetris.djj.machine_m.api.http;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.tetris.djj.machine_m.utils.LogUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adu on 2015/10/29.
 */


public class MultipartRequest extends Request<String> {

    private MultipartEntity entity = new MultipartEntity();

    private final Response.Listener<String> mListener;

    private Map<String, File> mFileParts;
    private Map<String, String> mParams;

    public MultipartRequest(String url, Response.ErrorListener errorListener,
                            Response.Listener<String> listener, Map<String, File> fileParams, Map<String, String> params) {
        super(Method.POST, url, errorListener);
        mListener = listener;
        mFileParts = fileParams;
        mParams = params;
        buildMultipartEntity();
    }


    private void buildMultipartEntity() {
        if (mFileParts != null && mFileParts.size() > 0) {
            for (Map.Entry<String, File> entry : mFileParts.entrySet()) {
                entity.addFilePart(entry.getKey(), entry.getValue());
            }
            long l = entity.getContentLength();
            LogUtils.i("MultipartRequest", mFileParts.size() + "个，长度：" + l);
        }

        if (mParams != null && mParams.size() > 0) {
            for (Map.Entry<String, String> entry : mParams.entrySet()) {
                entity.addStringPart(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public String getBodyContentType() {
        return entity.getContentType().getValue();
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            entity.writeTo(bos);
        } catch (IOException e) {
            VolleyLog.e("IOException writing to ByteArrayOutputStream");
        }
        return bos.toByteArray();
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        LogUtils.i("MultipartRequest", "parseNetworkResponse");
        if (VolleyLog.DEBUG) {
            if (response.headers != null) {
                for (Map.Entry<String, String> entry : response.headers
                        .entrySet()) {
                    VolleyLog.d(entry.getKey() + "=" + entry.getValue());
                }
            }
        }

        String parsed;
        try {
            parsed = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        return Response.success(parsed,
                HttpHeaderParser.parseCacheHeaders(response));
    }


    /*
     * (non-Javadoc)
     *
     * @see com.android.volley.Request#getHeaders()
     */
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        VolleyLog.d("getHeaders");
        Map<String, String> headers = super.getHeaders();

        if (headers == null || headers.equals(Collections.emptyMap())) {
            headers = new HashMap<String, String>();
        }
        return headers;
    }

    @Override
    protected void deliverResponse(String response) {
        mListener.onResponse(response);
    }
}