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
            descripcion = entity.descripcion,
            color = entity.color
        )
    }

    override fun mapToEntity(domainModel: Image): ImgCacheEntity {
        return ImgCacheEntity(
            id = domainModel.id,
            url = domainModel.url,
            descripcion = domainModel.descripcion,
            color = domainModel.color
        )
    }

    fun mapFromEntityList(entities: List<ImgCacheEntity>): List<Image>{
        return entities.map { mapFromEntity(it) }
    }
}