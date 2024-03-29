// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SearchRequest.proto

package com.adeng.protocolBuffer.demo.proto;

public final class SearchRequestProto {
  private SearchRequestProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface SearchRequestOrBuilder extends
      // @@protoc_insertion_point(interface_extends:SearchRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string query = 1;</code>
     * @return The query.
     */
    java.lang.String getQuery();
    /**
     * <code>string query = 1;</code>
     * @return The bytes for query.
     */
    com.google.protobuf.ByteString
        getQueryBytes();

    /**
     * <code>int32 page_number = 2;</code>
     * @return The pageNumber.
     */
    int getPageNumber();

    /**
     * <code>int32 result_per_page = 3;</code>
     * @return The resultPerPage.
     */
    int getResultPerPage();
  }
  /**
   * Protobuf type {@code SearchRequest}
   */
  public static final class SearchRequest extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:SearchRequest)
      SearchRequestOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use SearchRequest.newBuilder() to construct.
    private SearchRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private SearchRequest() {
      query_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new SearchRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private SearchRequest(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              query_ = s;
              break;
            }
            case 16: {

              pageNumber_ = input.readInt32();
              break;
            }
            case 24: {

              resultPerPage_ = input.readInt32();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.adeng.protocolBuffer.demo.proto.SearchRequestProto.internal_static_SearchRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.adeng.protocolBuffer.demo.proto.SearchRequestProto.internal_static_SearchRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest.class, com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest.Builder.class);
    }

    public static final int QUERY_FIELD_NUMBER = 1;
    private volatile java.lang.Object query_;
    /**
     * <code>string query = 1;</code>
     * @return The query.
     */
    @java.lang.Override
    public java.lang.String getQuery() {
      java.lang.Object ref = query_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        query_ = s;
        return s;
      }
    }
    /**
     * <code>string query = 1;</code>
     * @return The bytes for query.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getQueryBytes() {
      java.lang.Object ref = query_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        query_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PAGE_NUMBER_FIELD_NUMBER = 2;
    private int pageNumber_;
    /**
     * <code>int32 page_number = 2;</code>
     * @return The pageNumber.
     */
    @java.lang.Override
    public int getPageNumber() {
      return pageNumber_;
    }

    public static final int RESULT_PER_PAGE_FIELD_NUMBER = 3;
    private int resultPerPage_;
    /**
     * <code>int32 result_per_page = 3;</code>
     * @return The resultPerPage.
     */
    @java.lang.Override
    public int getResultPerPage() {
      return resultPerPage_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(query_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, query_);
      }
      if (pageNumber_ != 0) {
        output.writeInt32(2, pageNumber_);
      }
      if (resultPerPage_ != 0) {
        output.writeInt32(3, resultPerPage_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(query_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, query_);
      }
      if (pageNumber_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, pageNumber_);
      }
      if (resultPerPage_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, resultPerPage_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest)) {
        return super.equals(obj);
      }
      com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest other = (com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest) obj;

      if (!getQuery()
          .equals(other.getQuery())) return false;
      if (getPageNumber()
          != other.getPageNumber()) return false;
      if (getResultPerPage()
          != other.getResultPerPage()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + QUERY_FIELD_NUMBER;
      hash = (53 * hash) + getQuery().hashCode();
      hash = (37 * hash) + PAGE_NUMBER_FIELD_NUMBER;
      hash = (53 * hash) + getPageNumber();
      hash = (37 * hash) + RESULT_PER_PAGE_FIELD_NUMBER;
      hash = (53 * hash) + getResultPerPage();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code SearchRequest}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:SearchRequest)
        com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.adeng.protocolBuffer.demo.proto.SearchRequestProto.internal_static_SearchRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.adeng.protocolBuffer.demo.proto.SearchRequestProto.internal_static_SearchRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest.class, com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest.Builder.class);
      }

      // Construct using com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        query_ = "";

        pageNumber_ = 0;

        resultPerPage_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.adeng.protocolBuffer.demo.proto.SearchRequestProto.internal_static_SearchRequest_descriptor;
      }

      @java.lang.Override
      public com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest getDefaultInstanceForType() {
        return com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest.getDefaultInstance();
      }

      @java.lang.Override
      public com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest build() {
        com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest buildPartial() {
        com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest result = new com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest(this);
        result.query_ = query_;
        result.pageNumber_ = pageNumber_;
        result.resultPerPage_ = resultPerPage_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest) {
          return mergeFrom((com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest other) {
        if (other == com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest.getDefaultInstance()) return this;
        if (!other.getQuery().isEmpty()) {
          query_ = other.query_;
          onChanged();
        }
        if (other.getPageNumber() != 0) {
          setPageNumber(other.getPageNumber());
        }
        if (other.getResultPerPage() != 0) {
          setResultPerPage(other.getResultPerPage());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object query_ = "";
      /**
       * <code>string query = 1;</code>
       * @return The query.
       */
      public java.lang.String getQuery() {
        java.lang.Object ref = query_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          query_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string query = 1;</code>
       * @return The bytes for query.
       */
      public com.google.protobuf.ByteString
          getQueryBytes() {
        java.lang.Object ref = query_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          query_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string query = 1;</code>
       * @param value The query to set.
       * @return This builder for chaining.
       */
      public Builder setQuery(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        query_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string query = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearQuery() {
        
        query_ = getDefaultInstance().getQuery();
        onChanged();
        return this;
      }
      /**
       * <code>string query = 1;</code>
       * @param value The bytes for query to set.
       * @return This builder for chaining.
       */
      public Builder setQueryBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        query_ = value;
        onChanged();
        return this;
      }

      private int pageNumber_ ;
      /**
       * <code>int32 page_number = 2;</code>
       * @return The pageNumber.
       */
      @java.lang.Override
      public int getPageNumber() {
        return pageNumber_;
      }
      /**
       * <code>int32 page_number = 2;</code>
       * @param value The pageNumber to set.
       * @return This builder for chaining.
       */
      public Builder setPageNumber(int value) {
        
        pageNumber_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 page_number = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearPageNumber() {
        
        pageNumber_ = 0;
        onChanged();
        return this;
      }

      private int resultPerPage_ ;
      /**
       * <code>int32 result_per_page = 3;</code>
       * @return The resultPerPage.
       */
      @java.lang.Override
      public int getResultPerPage() {
        return resultPerPage_;
      }
      /**
       * <code>int32 result_per_page = 3;</code>
       * @param value The resultPerPage to set.
       * @return This builder for chaining.
       */
      public Builder setResultPerPage(int value) {
        
        resultPerPage_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 result_per_page = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearResultPerPage() {
        
        resultPerPage_ = 0;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:SearchRequest)
    }

    // @@protoc_insertion_point(class_scope:SearchRequest)
    private static final com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest();
    }

    public static com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<SearchRequest>
        PARSER = new com.google.protobuf.AbstractParser<SearchRequest>() {
      @java.lang.Override
      public SearchRequest parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new SearchRequest(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<SearchRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<SearchRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.adeng.protocolBuffer.demo.proto.SearchRequestProto.SearchRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SearchRequest_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SearchRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023SearchRequest.proto\"L\n\rSearchRequest\022\r" +
      "\n\005query\030\001 \001(\t\022\023\n\013page_number\030\002 \001(\005\022\027\n\017re" +
      "sult_per_page\030\003 \001(\005B9\n#com.adeng.protoco" +
      "lBuffer.demo.protoB\022SearchRequestProtob\006" +
      "proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_SearchRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_SearchRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SearchRequest_descriptor,
        new java.lang.String[] { "Query", "PageNumber", "ResultPerPage", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
