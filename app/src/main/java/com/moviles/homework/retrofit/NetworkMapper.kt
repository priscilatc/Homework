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
            height = entity.height,
            width = entity.width
        )
    }

    override fun mapToEntity(domainModel: Image): ImgNetworkEntity {
        return ImgNetworkEntity(
            id = domainModel.id,
            url = domainModel.url,
            height = domainModel.height,
            width = domainModel.width

        )
    }

    fun mapFromEntityList(entities: List<ImgNetworkEntity>) : List<Image>{
        return entities.map { mapFromEntity(it) }
    }
}