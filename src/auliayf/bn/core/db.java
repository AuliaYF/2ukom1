/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auliayf.bn.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * db engine
 * @author AuliaYF
 */
public class db {

    // <editor-fold defaultstate="collapsed" desc="Beware! This is my brain's children"> 
    // <editor-fold defaultstate="collapsed" desc="This is the db engine">
    private static final String DB_NAME = "2ukom1";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    /**
     *
     * @return
     */
    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    /**
     *
     * @param q
     * @return
     */
    public static List<Model> query(Query q) {
        List<Model> models = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        String cols[];

        try {
            conn = getConn();
            statement = conn.createStatement();
            rs = statement.executeQuery(q.toString());
            cols = getCols(rs);

            while (rs.next()) {
                Model model = new Model();

                for (String col : cols) {
                    model.set(col, rs.getObject(col));
                }

                models.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return models;
    }

    private static String[] getCols(ResultSet rs) throws SQLException {
        ResultSetMetaData meta = rs.getMetaData();
        int count = meta.getColumnCount();
        String cols[] = new String[count];

        for (int i = 1; i <= count; i++) {
            cols[i - 1] = meta.getColumnName(i);
        }

        return cols;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="This is the db model">

    /**
     *
     */
        public static class Model {

        private final HashMap<String, Object> mMap = new HashMap<>();

        /**
         *
         * @param key
         * @param value
         * @return
         */
        public Model set(String key, Object value) {
            this.mMap.put(key, value);
            return this;
        }

        /**
         *
         * @param key
         * @return
         */
        public Object get(String key) {
            return this.mMap.get(key);
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="This is the Query Builder!">

    /**
     *
     */
        public static class Query {

        private String TABLE = null;
        private final ArrayList<String> mSelect = new ArrayList<>();
        private final ArrayList<String[]> mJoin = new ArrayList<>();
        private final ArrayList<String[]> mWhere = new ArrayList<>();
        private final ArrayList<String[]> mLike = new ArrayList<>();
        private String[] mSort = null;
        private Integer[] mLimit = null;

        /**
         *
         * @param table_name
         */
        public Query(String table_name) {
            this.TABLE = table_name;
        }

        /**
         *
         * @param select
         * @return
         */
        public Query select(String select) {
            this.mSelect.add(select);
            return this;
        }

        /**
         *
         * @param field
         * @return
         */
        public Query min(String field) {
            this.mSelect.add("MIN(" + field + ")");
            return this;
        }

        /**
         *
         * @param field
         * @return
         */
        public Query max(String field) {
            this.mSelect.add("MAX(" + field + ")");
            return this;
        }

        /**
         *
         * @param field
         * @return
         */
        public Query avg(String field) {
            this.mSelect.add("AVG(" + field + ")");
            return this;
        }

        /**
         *
         * @param table
         * @param arg
         * @param mode
         * @return
         */
        public Query join(String table, String arg, String mode) {
            this.mJoin.add(new String[]{mode, table, arg});
            return this;
        }

        /**
         *
         * @param field
         * @param value
         * @return
         */
        public Query join_where(String field, String value) {
            this.mWhere.add(new String[]{" AND ", field + " = " + value});
            return this;
        }

        /**
         *
         * @param field
         * @param value
         * @return
         */
        public Query join_or_where(String field, String value) {
            this.mWhere.add(new String[]{" OR ", field + " = " + value});
            return this;
        }

        /**
         *
         * @param field
         * @param value
         * @return
         */
        public Query where(String field, String value) {
            this.mWhere.add(new String[]{" AND ", field + " = '" + value + "'"});
            return this;
        }

        /**
         *
         * @param field
         * @param value
         * @return
         */
        public Query or_where(String field, String value) {
            this.mWhere.add(new String[]{" OR ", field + " = '" + value + "'"});
            return this;
        }

        /**
         *
         * @param type
         * @param where
         * @return
         */
        public Query special_where(String type, String[]  
            ... where){
           StringBuilder builder = new StringBuilder();
            builder.append("(");

            boolean first = true;
            for (String[] arg : where) {
                if (!first) {
                    builder.append(type);
                }
                builder.append(arg[0]).append(" = '").append(arg[1]).append("'");
                first = false;
            }

            builder.append(")");

            this.mWhere.add(new String[]{" AND ", builder.toString()});
            return this;
        }

        /**
         *
         * @param type
         * @param where
         * @return
         */
        public Query special_or_where(String type, String[]  
            ... where){
           StringBuilder builder = new StringBuilder();
            builder.append("(");

            boolean first = true;
            for (String[] arg : where) {
                if (!first) {
                    builder.append(type);
                }
                builder.append(arg[0]).append(" = '").append(arg[1]).append("'");
                first = false;
            }

            builder.append(")");

            this.mWhere.add(new String[]{" OR ", builder.toString()});
            return this;
        }

        /**
         *
         * @param field
         * @param value
         * @return
         */
        public Query like(String field, String value) {
            this.mLike.add(new String[]{" AND ", field + " LIKE '%" + value + "%'"});
            return this;
        }

        /**
         *
         * @param field
         * @param value
         * @return
         */
        public Query or_like(String field, String value) {
            this.mLike.add(new String[]{" OR ", field + " LIKE '%" + value + "%'"});
            return this;
        }

        /**
         *
         * @param type
         * @param like
         * @return
         */
        public Query special_like(String type, String[]  
            ... like){
           StringBuilder builder = new StringBuilder();
            builder.append("(");

            boolean first = true;
            for (String[] arg : like) {
                if (!first) {
                    builder.append(type);
                }
                builder.append(arg[0]).append(" LIKE '%").append(arg[1]).append("%'");
                first = false;
            }

            builder.append(")");

            this.mWhere.add(new String[]{" AND ", builder.toString()});
            return this;
        }

        /**
         *
         * @param type
         * @param like
         * @return
         */
        public Query special_or_like(String type, String[]  
            ... like){
           StringBuilder builder = new StringBuilder();
            builder.append("(");

            boolean first = true;
            for (String[] arg : like) {
                if (!first) {
                    builder.append(type);
                }
                builder.append(arg[0]).append(" LIKE '%").append(arg[1]).append("%'");
                first = false;
            }

            builder.append(")");

            this.mWhere.add(new String[]{" OR ", builder.toString()});
            return this;
        }

        /**
         *
         * @param field
         * @return
         */
        public Query asc(String field) {
            this.mSort = new String[2];
            this.mSort[0] = "ASC";
            this.mSort[1] = field;
            return this;
        }

        /**
         *
         * @param field
         * @return
         */
        public Query desc(String field) {
            this.mSort = new String[2];
            this.mSort[0] = "DESC";
            this.mSort[1] = field;
            return this;
        }

        /**
         *
         * @param limit
         * @return
         */
        public Query limit(int limit) {
            this.mLimit = new Integer[2];
            this.mLimit[0] = limit;
            this.mLimit[1] = null;
            return this;
        }

        /**
         *
         * @param limit
         * @param offset
         * @return
         */
        public Query limit(int limit, int offset) {
            this.mLimit = new Integer[2];
            this.mLimit[0] = limit;
            this.mLimit[1] = offset;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();

            if (mSelect.size() < 1) {
                builder.append("SELECT * FROM ").append(TABLE);
            } else {
                builder.append("SELECT ");

                boolean first = true;
                for (String select : mSelect) {
                    if (!first) {
                        builder.append(", ");
                    }
                    builder.append(select);
                    first = false;
                }

                builder.append(" FROM ").append(TABLE);
            }

            if (mJoin.size() > 0) {
                for (String[] join : mJoin) {
                    if (join[0].isEmpty()) {
                        builder.append(" JOIN ");
                    } else {
                        builder.append(" ").append(join[0]).append(" JOIN ");
                    }
                    builder.append(join[1]).append(" ON ").append(join[2]);
                }
            }

            if (mWhere.size() > 0) {
                builder.append(" WHERE ");

                boolean first = true;
                for (String[] where : mWhere) {
                    if (!first) {
                        builder.append(where[0]);
                    }
                    builder.append(where[1]);
                    first = false;
                }
            }

            if (mLike.size() > 0) {
                if (mWhere.size() < 1) {
                    builder.append(" WHERE ");

                    boolean first = true;
                    for (String[] like : mLike) {
                        if (!first) {
                            builder.append(like[0]);
                        }
                        builder.append(like[1]);
                        first = false;
                    }
                } else {
                    for (String[] like : mLike) {
                        builder.append(like[0]);
                        builder.append(like[1]);
                    }
                }
            }

            if (mSort != null) {
                builder.append(" ORDER BY ");
                builder.append(mSort[1]).append(" ").append(mSort[0]);
            }

            if (mLimit != null) {
                if (mLimit[1] != null) {
                    builder.append(" LIMIT ").append(mLimit[0]).append(",").append(mLimit[1]);
                } else {
                    builder.append(" LIMIT ").append(mLimit[0]);
                }
            }

            return builder.toString();
        }
    }
    // </editor-fold>
    // </editor-fold>
}
