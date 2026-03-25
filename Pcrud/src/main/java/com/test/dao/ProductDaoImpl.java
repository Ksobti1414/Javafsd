package com.test.dao;
import java.util.*;
import java.sql.*;
import com.test.db.ConnectionDb;
import com.test.model.Product;
public class ProductDaoImpl implements ProductDao {
	@Override
public int saveProduct(Product obj) {
	String sql="insert into product(p_name,p_brand,p_price)values(?,?,?)";
	int x=0;
	try {
		PreparedStatement pst=ConnectionDb.getCon().prepareStatement(sql);
		pst.setString(1, obj.getName());
		pst.setString(2, obj.getB_name());
		pst.setDouble(3,obj.getPrice());
		x=pst.executeUpdate();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return x;
}
	@Override
	public List<Product>listallproducts(){
		List<Product>list=new ArrayList<>();
		try {
			String sql="Select * from product";
			PreparedStatement pst=ConnectionDb.getCon().prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("p_name"));
				p.setB_name(rs.getString("p_brand"));
				p.setPrice(rs.getDouble("p_price"));
				list.add(p);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	@Override
	public Product getProductById(int id) {
		Product p=null;
		try {
			String sql="Select* from product where id=?";
			PreparedStatement pst=ConnectionDb.getCon().prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				p=new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("p_name"));
				p.setB_name(rs.getString("p_brand"));
				p.setPrice(rs.getDouble("p_price"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	@Override
	public int deleteProductById(int id) {
		int x=0;
		try {
			String sql="Delete from product where id=?";
			PreparedStatement pst=ConnectionDb.getCon().prepareStatement(sql);
			pst.setInt(1, id);
			x=pst.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	@Override
	public int updateProduct(Product obj) {
		int x=0;
		try {
			String sql="Update product set p_name=?,p_brand=?,p_price=? where id=?";
			PreparedStatement pst=ConnectionDb.getCon().prepareStatement(sql);
			pst.setString(1, obj.getName());
			pst.setString(2, obj.getB_name());
			pst.setDouble(3, obj.getPrice());
			pst.setInt(4, obj.getId());
			x=pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return x;
	}
}
