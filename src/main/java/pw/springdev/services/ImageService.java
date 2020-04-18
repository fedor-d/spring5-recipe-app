package pw.springdev.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by FedorD on 2020-04-18
 */
public interface ImageService {

    void saveImageFile(Long recipeId, MultipartFile file);
}
