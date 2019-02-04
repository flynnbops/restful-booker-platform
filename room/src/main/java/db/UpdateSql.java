package db;

import model.Room;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateSql {

    private PreparedStatement preparedStatement;

    UpdateSql(Connection connection, int id, Room room) throws SQLException {
        String UPDATE_ROOM = "UPDATE ROOMS SET room_number = ?, type = ?, beds = ?, accessible = ?, image = ?, description = ?, features = ? WHERE roomid = ?";

        preparedStatement = connection.prepareStatement(UPDATE_ROOM);
        preparedStatement.setInt(1, room.getRoomNumber());
        preparedStatement.setString(2, room.getType());
        preparedStatement.setInt(3, room.getBeds());
        preparedStatement.setBoolean(4, room.isAccessible());
        preparedStatement.setString(5, room.getImage());
        preparedStatement.setString(6, room.getDescription());

        Array featuresArray = connection.createArrayOf("VARCHAR", room.getFeatures());
        preparedStatement.setArray(7, featuresArray);

        preparedStatement.setInt(8, id);
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

}
