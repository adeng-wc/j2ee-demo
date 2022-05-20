package com.adeng.protocolBuffer.demo.proto;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author wengcheng on 2022/5/20
 */
public class Test {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SearchRequestProto.SearchRequest searchRequest = SearchRequestProto.SearchRequest.newBuilder()
                .setQuery("query123")
                .setPageNumber(1)
                .setResultPerPage(2)
                .build();
        System.out.println(searchRequest);

        for(byte b : searchRequest.toByteArray()){
            System.out.print(b);
        }

        System.out.println();
        System.out.println(searchRequest.toByteString());
        System.out.println(searchRequest.toByteString().size());

        System.out.println();

        // 反序列化
        SearchRequestProto.SearchRequest parse = SearchRequestProto.SearchRequest.parseFrom(searchRequest.toByteArray());
        System.out.println(parse);
    }
}
