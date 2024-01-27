package com.glassait.equipment_tanks.adapters;

import com.glassait.equipment_tanks.api.model.MemberDto;
import com.glassait.equipment_tanks.api.model.MemberEnum;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class MemberDtoAdapter extends TypeAdapter<MemberDto> {

    @Override
    public void write(JsonWriter out, MemberDto value) throws IOException {
        out.beginObject();
        out.name("role");
        out.value(value.getRole());
        out.name("account_id");
        out.value(value.getAccountId());
        out.endObject();
    }

    @Override
    public MemberDto read(JsonReader in) throws IOException {
        var member = new MemberDto();
        in.beginObject();
        String fieldName = null;

        while (in.hasNext()) {
            var token = in.peek();

            if (token.equals(JsonToken.NAME)) {
                fieldName = in.nextName();
            }

            if (MemberEnum.ROLE.toString().equals(fieldName)) {
                token = in.peek(); // NOSONAR
                member.setRole(in.nextString());
            }

            if (MemberEnum.ACCOUNT_ID.toString().equals(fieldName)) {
                token = in.peek(); // NOSONAR
                member.setAccountId(in.nextInt());
            }
        }
        in.endObject();

        return member;
    }
}
