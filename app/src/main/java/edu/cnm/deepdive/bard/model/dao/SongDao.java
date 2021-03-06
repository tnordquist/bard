package edu.cnm.deepdive.bard.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.bard.model.entity.Song;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * The {@link SongDao} provides the CRUD (create, read, update, delete) functions, as well as
 * specialized queries for the repository.
 */
@Dao
public interface SongDao {

  @Insert
  Single<Long> insert(Song song);

  @Insert
  Single<List<Long>> insert(Song... songs);

  @Insert
  Single<List<Long>> insert(Collection<Song> songs);

  @Update
  Single<Integer> update(Song song);

  @Update
  Single<Integer> update(Song... songs);

  @Update
  Single<Integer> update(Collection<Song> songs);

  @Delete
  Single<Integer> delete(Song song);

  @Delete
  Single<Integer> delete(Song... songs);

  @Delete
  Single<Integer> delete(Collection<Song> songs);

  @Query("SELECT * FROM Song WHERE song_id = :songId")
  LiveData<Song> getSongById(long songId);

  @Query("SELECT * FROM Song ORDER BY song_name ASC")
  LiveData<List<Song>> getAll();

  @Query("SELECT * FROM Song WHERE song_name LIKE :songNameFragment ORDER BY song_name ASC")
  LiveData<List<Song>> getSongByName(String songNameFragment);

  @Query("SELECT * FROM Song WHERE artist LIKE :artistNameFragment ORDER BY song_name ASC")
  LiveData<List<Song>> getSongByArtist(String artistNameFragment);

  @Query("SELECT * FROM Song WHERE album LIKE :albumNameFragment ORDER BY album ASC, song_name ASC")
  LiveData<List<Song>> getSongByAlbum(String albumNameFragment);
}
