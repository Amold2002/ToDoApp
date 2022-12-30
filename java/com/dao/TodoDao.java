package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.ToDoDetails;

public class TodoDao {

	private Connection conn;

	public TodoDao(Connection conn) {
		this.conn = conn;
	}

	public boolean addTodo(String name, String todo, String status) {
		boolean f = false;

		try {
			String sql = "insert into todo(name,todo,status) values(?,?,?);";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, name);
			ps.setString(2, todo);
			ps.setString(3, status);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return f;

	}

	public List<ToDoDetails> getTodo() {
		List<ToDoDetails> list = new ArrayList<ToDoDetails>();

		ToDoDetails t = null;
		try {
			String sql = "select * from todo;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				t = new ToDoDetails();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setTodo(rs.getString(3));
				t.setStatus(rs.getString(4));
				list.add(t);
			}
		} catch (Exception e) {

		}
		return list;
	}

	public ToDoDetails getToDoById(int id) {
		ToDoDetails t = null;
		try {

			String sql = "select * from todo where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				t = new ToDoDetails();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setTodo(rs.getString(3));
				t.setStatus(rs.getString(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return t;
	}

	public boolean updateTodo(ToDoDetails t) {
		boolean f = false;

		try {

			String sql = "update todo set name=?,todo=?,status=? where id=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, t.getName());
			ps.setString(2, t.getTodo());
			ps.setString(3, t.getStatus());
			ps.setInt(4, t.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

}
