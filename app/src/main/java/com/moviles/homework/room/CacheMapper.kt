package com.moviles.homework.room

import com.moviles.homework.model.Image
import com.moviles.homework.utils.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():
    EntityMapper<ImgCacheEntity, Image>{
    override fun mapFromEntity(entity: ImgCacheEntity): Image {
        return Image(
            id = entity.id,
            url = entity.url,
            height = entity.height,
            width = entity.height
        )
    }

    override fun mapToEntity(domainModel: Image): ImgCacheEntity {
        return ImgCacheEntity(
            id = domainModel.id,
            url = domainModel.url,
            height = domainModel.height,
            width = domainModel.width
        )
    }

    fun mapFromEntityList(entities: List<ImgCacheEntity>): List<Image>{
        return entities.map { mapFromEntity(it) }
    }
}