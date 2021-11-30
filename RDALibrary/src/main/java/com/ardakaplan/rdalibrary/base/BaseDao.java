package com.ardakaplan.rdalibrary.base;

/**
 * Created by Arda Kaplan at 17-Aug-20 - 22:32
 * <p>
 * ardakaplan101@gmail.com
 */
public interface BaseDao {

    //SELECT
    String SELECT_ALL_FROM = "SELECT * FROM ";
    String SELECT_COUNT_ALL_FROM = "SELECT COUNT(*) FROM ";

    //DELETE
    String DELETE_FROM = "DELETE FROM ";

    //UPDATE
    String UPDATE = "UPDATE ";

    //WHERE
    String WHERE = " WHERE ";

    //SET
    String SET = " SET ";

    //ORDER BY
    String ORDER_BY = " ORDER BY ";
    String ASC = " ASC";
    String DESC = " DESC";

    String AND = " AND ";
    String OR = " OR ";
}
