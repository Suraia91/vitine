/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.suraia.andela.vitrine.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.suraia.andela.vitrine.data.model.Dados
import kotlinx.coroutines.flow.Flow

/**
 * The Data Access Object for the Plant class.
 */
@Dao
interface TimeDao {
    @Query("SELECT * FROM Dados ORDER BY id")
    fun getTimes(): LiveData<List<Dados>>

    @Query("SELECT * from Dados ORDER BY id")
    fun getTimesFlow(): Flow<List<Dados>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(times: List<Dados>)

}
