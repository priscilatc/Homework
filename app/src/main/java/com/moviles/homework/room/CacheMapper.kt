package com.moviles.homework.room

import com.moviles.homework.model.Dog
import com.moviles.homework.utils.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():
    EntityMapper<DogCacheEntity, Dog>{
    override fun mapFromEntity(entity: DogCacheEntity): Dog {
        return Dog(
            id = entity.id,
            url = entity.url,
            height = entity.height,
            width = entity.height
        )
    }

    override fun mapToEntity(domainModel: Dog): DogCacheEntity {
        return DogCacheEntity(
            id = domainModel.id,
            url = domainModel.url,
            height = domainModel.height,
            width = domainModel.width
        )
    }

    fun mapFromEntityList(entities: List<DogCacheEntity>): List<Dog>{
        return entities.map { mapFromEntity(it) }
    }
}