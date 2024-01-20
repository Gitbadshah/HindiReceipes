import androidx.room.Database
import androidx.room.RoomDatabase
import com.badshahapps.hindireceipe.Dao
import com.badshahapps.hindireceipe.Recipe

@Database(entities = [Recipe::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): Dao
}