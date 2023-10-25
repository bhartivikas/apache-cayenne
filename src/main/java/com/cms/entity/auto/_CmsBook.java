package com.cms.entity.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.property.DateProperty;
import org.apache.cayenne.exp.property.PropertyFactory;
import org.apache.cayenne.exp.property.StringProperty;

/**
 * Class _CmsBook was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CmsBook extends BaseDataObject {

    private static final long serialVersionUID = 1L;

    public static final String ID_PK_COLUMN = "id";

    public static final DateProperty<LocalDateTime> CREATED_AT = PropertyFactory.createDate("createdAt", LocalDateTime.class);
    public static final StringProperty<String> CREATED_BY = PropertyFactory.createString("createdBy", String.class);
    public static final StringProperty<String> ISBN = PropertyFactory.createString("isbn", String.class);
    public static final StringProperty<String> NAME = PropertyFactory.createString("name", String.class);
    public static final DateProperty<LocalDateTime> UPDATED_AT = PropertyFactory.createDate("updatedAt", LocalDateTime.class);
    public static final StringProperty<String> UPDATED_BY = PropertyFactory.createString("updatedBy", String.class);

    protected LocalDateTime createdAt;
    protected String createdBy;
    protected String isbn;
    protected String name;
    protected LocalDateTime updatedAt;
    protected String updatedBy;


    public void setCreatedAt(LocalDateTime createdAt) {
        beforePropertyWrite("createdAt", this.createdAt, createdAt);
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        beforePropertyRead("createdAt");
        return this.createdAt;
    }

    public void setCreatedBy(String createdBy) {
        beforePropertyWrite("createdBy", this.createdBy, createdBy);
        this.createdBy = createdBy;
    }

    public String getCreatedBy() {
        beforePropertyRead("createdBy");
        return this.createdBy;
    }

    public void setIsbn(String isbn) {
        beforePropertyWrite("isbn", this.isbn, isbn);
        this.isbn = isbn;
    }

    public String getIsbn() {
        beforePropertyRead("isbn");
        return this.isbn;
    }

    public void setName(String name) {
        beforePropertyWrite("name", this.name, name);
        this.name = name;
    }

    public String getName() {
        beforePropertyRead("name");
        return this.name;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        beforePropertyWrite("updatedAt", this.updatedAt, updatedAt);
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getUpdatedAt() {
        beforePropertyRead("updatedAt");
        return this.updatedAt;
    }

    public void setUpdatedBy(String updatedBy) {
        beforePropertyWrite("updatedBy", this.updatedBy, updatedBy);
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() {
        beforePropertyRead("updatedBy");
        return this.updatedBy;
    }

    protected abstract void onPreUpdate();

    protected abstract void onPrePersist();

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "createdAt":
                return this.createdAt;
            case "createdBy":
                return this.createdBy;
            case "isbn":
                return this.isbn;
            case "name":
                return this.name;
            case "updatedAt":
                return this.updatedAt;
            case "updatedBy":
                return this.updatedBy;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "createdAt":
                this.createdAt = (LocalDateTime)val;
                break;
            case "createdBy":
                this.createdBy = (String)val;
                break;
            case "isbn":
                this.isbn = (String)val;
                break;
            case "name":
                this.name = (String)val;
                break;
            case "updatedAt":
                this.updatedAt = (LocalDateTime)val;
                break;
            case "updatedBy":
                this.updatedBy = (String)val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.createdAt);
        out.writeObject(this.createdBy);
        out.writeObject(this.isbn);
        out.writeObject(this.name);
        out.writeObject(this.updatedAt);
        out.writeObject(this.updatedBy);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.createdAt = (LocalDateTime)in.readObject();
        this.createdBy = (String)in.readObject();
        this.isbn = (String)in.readObject();
        this.name = (String)in.readObject();
        this.updatedAt = (LocalDateTime)in.readObject();
        this.updatedBy = (String)in.readObject();
    }

}