/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.avro.accountcreate.event;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class account_create_event extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5124933079402731339L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"account_create_event\",\"namespace\":\"com.avro.accountcreate.event\",\"fields\":[{\"name\":\"account_name\",\"type\":\"string\"},{\"name\":\"account_create_time\",\"type\":\"string\"},{\"name\":\"notify_days\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<account_create_event> ENCODER =
      new BinaryMessageEncoder<account_create_event>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<account_create_event> DECODER =
      new BinaryMessageDecoder<account_create_event>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<account_create_event> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<account_create_event> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<account_create_event> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<account_create_event>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this account_create_event to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a account_create_event from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a account_create_event instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static account_create_event fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence account_name;
  @Deprecated public java.lang.CharSequence account_create_time;
  @Deprecated public java.lang.CharSequence notify_days;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public account_create_event() {}

  /**
   * All-args constructor.
   * @param account_name The new value for account_name
   * @param account_create_time The new value for account_create_time
   * @param notify_days The new value for notify_days
   */
  public account_create_event(java.lang.CharSequence account_name, java.lang.CharSequence account_create_time, java.lang.CharSequence notify_days) {
    this.account_name = account_name;
    this.account_create_time = account_create_time;
    this.notify_days = notify_days;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return account_name;
    case 1: return account_create_time;
    case 2: return notify_days;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: account_name = (java.lang.CharSequence)value$; break;
    case 1: account_create_time = (java.lang.CharSequence)value$; break;
    case 2: notify_days = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'account_name' field.
   * @return The value of the 'account_name' field.
   */
  public java.lang.CharSequence getAccountName() {
    return account_name;
  }


  /**
   * Sets the value of the 'account_name' field.
   * @param value the value to set.
   */
  public void setAccountName(java.lang.CharSequence value) {
    this.account_name = value;
  }

  /**
   * Gets the value of the 'account_create_time' field.
   * @return The value of the 'account_create_time' field.
   */
  public java.lang.CharSequence getAccountCreateTime() {
    return account_create_time;
  }


  /**
   * Sets the value of the 'account_create_time' field.
   * @param value the value to set.
   */
  public void setAccountCreateTime(java.lang.CharSequence value) {
    this.account_create_time = value;
  }

  /**
   * Gets the value of the 'notify_days' field.
   * @return The value of the 'notify_days' field.
   */
  public java.lang.CharSequence getNotifyDays() {
    return notify_days;
  }


  /**
   * Sets the value of the 'notify_days' field.
   * @param value the value to set.
   */
  public void setNotifyDays(java.lang.CharSequence value) {
    this.notify_days = value;
  }

  /**
   * Creates a new account_create_event RecordBuilder.
   * @return A new account_create_event RecordBuilder
   */
  public static com.avro.accountcreate.event.account_create_event.Builder newBuilder() {
    return new com.avro.accountcreate.event.account_create_event.Builder();
  }

  /**
   * Creates a new account_create_event RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new account_create_event RecordBuilder
   */
  public static com.avro.accountcreate.event.account_create_event.Builder newBuilder(com.avro.accountcreate.event.account_create_event.Builder other) {
    if (other == null) {
      return new com.avro.accountcreate.event.account_create_event.Builder();
    } else {
      return new com.avro.accountcreate.event.account_create_event.Builder(other);
    }
  }

  /**
   * Creates a new account_create_event RecordBuilder by copying an existing account_create_event instance.
   * @param other The existing instance to copy.
   * @return A new account_create_event RecordBuilder
   */
  public static com.avro.accountcreate.event.account_create_event.Builder newBuilder(com.avro.accountcreate.event.account_create_event other) {
    if (other == null) {
      return new com.avro.accountcreate.event.account_create_event.Builder();
    } else {
      return new com.avro.accountcreate.event.account_create_event.Builder(other);
    }
  }

  /**
   * RecordBuilder for account_create_event instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<account_create_event>
    implements org.apache.avro.data.RecordBuilder<account_create_event> {

    private java.lang.CharSequence account_name;
    private java.lang.CharSequence account_create_time;
    private java.lang.CharSequence notify_days;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.avro.accountcreate.event.account_create_event.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.account_name)) {
        this.account_name = data().deepCopy(fields()[0].schema(), other.account_name);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.account_create_time)) {
        this.account_create_time = data().deepCopy(fields()[1].schema(), other.account_create_time);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.notify_days)) {
        this.notify_days = data().deepCopy(fields()[2].schema(), other.notify_days);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing account_create_event instance
     * @param other The existing instance to copy.
     */
    private Builder(com.avro.accountcreate.event.account_create_event other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.account_name)) {
        this.account_name = data().deepCopy(fields()[0].schema(), other.account_name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.account_create_time)) {
        this.account_create_time = data().deepCopy(fields()[1].schema(), other.account_create_time);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.notify_days)) {
        this.notify_days = data().deepCopy(fields()[2].schema(), other.notify_days);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'account_name' field.
      * @return The value.
      */
    public java.lang.CharSequence getAccountName() {
      return account_name;
    }


    /**
      * Sets the value of the 'account_name' field.
      * @param value The value of 'account_name'.
      * @return This builder.
      */
    public com.avro.accountcreate.event.account_create_event.Builder setAccountName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.account_name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'account_name' field has been set.
      * @return True if the 'account_name' field has been set, false otherwise.
      */
    public boolean hasAccountName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'account_name' field.
      * @return This builder.
      */
    public com.avro.accountcreate.event.account_create_event.Builder clearAccountName() {
      account_name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'account_create_time' field.
      * @return The value.
      */
    public java.lang.CharSequence getAccountCreateTime() {
      return account_create_time;
    }


    /**
      * Sets the value of the 'account_create_time' field.
      * @param value The value of 'account_create_time'.
      * @return This builder.
      */
    public com.avro.accountcreate.event.account_create_event.Builder setAccountCreateTime(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.account_create_time = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'account_create_time' field has been set.
      * @return True if the 'account_create_time' field has been set, false otherwise.
      */
    public boolean hasAccountCreateTime() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'account_create_time' field.
      * @return This builder.
      */
    public com.avro.accountcreate.event.account_create_event.Builder clearAccountCreateTime() {
      account_create_time = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'notify_days' field.
      * @return The value.
      */
    public java.lang.CharSequence getNotifyDays() {
      return notify_days;
    }


    /**
      * Sets the value of the 'notify_days' field.
      * @param value The value of 'notify_days'.
      * @return This builder.
      */
    public com.avro.accountcreate.event.account_create_event.Builder setNotifyDays(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.notify_days = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'notify_days' field has been set.
      * @return True if the 'notify_days' field has been set, false otherwise.
      */
    public boolean hasNotifyDays() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'notify_days' field.
      * @return This builder.
      */
    public com.avro.accountcreate.event.account_create_event.Builder clearNotifyDays() {
      notify_days = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public account_create_event build() {
      try {
        account_create_event record = new account_create_event();
        record.account_name = fieldSetFlags()[0] ? this.account_name : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.account_create_time = fieldSetFlags()[1] ? this.account_create_time : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.notify_days = fieldSetFlags()[2] ? this.notify_days : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<account_create_event>
    WRITER$ = (org.apache.avro.io.DatumWriter<account_create_event>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<account_create_event>
    READER$ = (org.apache.avro.io.DatumReader<account_create_event>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.account_name);

    out.writeString(this.account_create_time);

    out.writeString(this.notify_days);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.account_name = in.readString(this.account_name instanceof Utf8 ? (Utf8)this.account_name : null);

      this.account_create_time = in.readString(this.account_create_time instanceof Utf8 ? (Utf8)this.account_create_time : null);

      this.notify_days = in.readString(this.notify_days instanceof Utf8 ? (Utf8)this.notify_days : null);

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.account_name = in.readString(this.account_name instanceof Utf8 ? (Utf8)this.account_name : null);
          break;

        case 1:
          this.account_create_time = in.readString(this.account_create_time instanceof Utf8 ? (Utf8)this.account_create_time : null);
          break;

        case 2:
          this.notify_days = in.readString(this.notify_days instanceof Utf8 ? (Utf8)this.notify_days : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









