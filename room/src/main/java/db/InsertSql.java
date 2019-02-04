package db;

import model.Room;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSql {

    private PreparedStatement preparedStatement;

    private int roomNumber;
    private String type;
    private int beds;
    private boolean accessible;
    private String image;
    private String description;
    private String[] features;

    InsertSql(Connection connection, Room room) throws SQLException {
        final String CREATE_ROOM = "INSERT INTO ROOMS (room_number, type, beds, accessible, image, description, features) VALUES(?, ?, ?, ?, ?, ?, ?);";

        preparedStatement = connection.prepareStatement(CREATE_ROOM);
        preparedStatement.setInt(1, room.getRoomNumber());
        preparedStatement.setString(2, room.getType());
        preparedStatement.setInt(3, room.getBeds());
        preparedStatement.setBoolean(4, room.isAccessible());
        preparedStatement.setString(5, room.getImage());
        preparedStatement.setString(6, room.getDescription());

        Array featuresArray = connection.createArrayOf("VARCHAR", room.getFeatures());
        preparedStatement.setArray(7, featuresArray);
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }
}
