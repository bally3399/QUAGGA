package africa.semicolon.com.quagga.services;


import africa.semicolon.com.quagga.data.models.Category;
import africa.semicolon.com.quagga.dtos.request.CreateProductRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public class TestUtils {
    public static final String TEST_IMAGE_LOCATION = "C:\\Users\\DELL\\Documents\\GitHub\\maverickshub\\src\\main\\resources\\static\\img.png";
    public static final String TEST_VIDEO_LOCATION = "C:\\Users\\DELL\\Desktop\\Semicolon\\vid.mp4";
    public static CreateProductRequest buildUploadProductRequest(InputStream inputStream) throws IOException {
        CreateProductRequest uploadRequest = new CreateProductRequest();
        MultipartFile file = new MockMultipartFile("product",inputStream);
        uploadRequest.setMediaFile(file);
        uploadRequest.setSupplierId(4L);
        uploadRequest.setCategory(Category.ELECTRICAL);
        return uploadRequest;
    }

}
