package com.moviles.homework.retrofit

import com.moviles.homework.model.Image
import com.moviles.homework.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor(): EntityMapper<ImgNetworkEntity, Image> {
    override fun mapFromEntity(entity: ImgNetworkEntity): Image {
        return Image(
            id = entity.id,
            url = entity.url,
            descripcion = entity.descripcion,
            color = entity.color
        )
    }

    override fun mapToEntity(domainModel: Image): ImgNetworkEntity {
        return ImgNetworkEntity(
            id = domainModel.id,
            url = domainModel.url,
            descripcion = domainModel.descripcion,
            color = domainModel.color

        )
    }

    fun mapFromEntityList(entities: List<ImgNetworkEntity>) : List<Image>{
        return entities.map { mapFromEntity(it) }
    }
}