package com.kjh.boardback.repository.resultSet;

public interface GetRecipeBoardResultSet {
    Integer getBoardNumber();
    String getTitle();
    String getContent();
    String getWriteDatetime();
    String getWriterEmail();
    String getWriterNickname();
    String getWriterProfileImage();
    Integer getType();

}
