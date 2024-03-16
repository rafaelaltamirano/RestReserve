package com.quandoo.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.domain.model.Table;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TablesDao_RestaurantDatabaseTest_Impl implements TablesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Table> __insertionAdapterOfTable;

  public TablesDao_RestaurantDatabaseTest_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTable = new EntityInsertionAdapter<Table>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `tables` (`shape`,`id`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Table value) {
        if (value.getShape() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getShape());
        }
        stmt.bindLong(2, value.getId());
      }
    };
  }

  @Override
  public Object insertAll(final List<Table> banks, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTable.insert(banks);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAll(final Continuation<? super List<Table>> $completion) {
    final String _sql = "SELECT * FROM tables";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Table>>() {
      @Override
      public List<Table> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfShape = CursorUtil.getColumnIndexOrThrow(_cursor, "shape");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Table> _result = new ArrayList<Table>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Table _item;
            final String _tmpShape;
            if (_cursor.isNull(_cursorIndexOfShape)) {
              _tmpShape = null;
            } else {
              _tmpShape = _cursor.getString(_cursorIndexOfShape);
            }
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new Table(_tmpShape,_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
