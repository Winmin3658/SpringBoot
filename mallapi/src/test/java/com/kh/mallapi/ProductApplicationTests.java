package com.kh.mallapi;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.kh.mallapi.domain.Product;
import com.kh.mallapi.dto.PageRequestDTO;
import com.kh.mallapi.dto.PageResponseDTO;
import com.kh.mallapi.dto.ProductDTO;
import com.kh.mallapi.repository.ProductRepository;
import com.kh.mallapi.service.ProductService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class ProductApplicationTests {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	ProductService productService;

	// @Test
	public void productInsert() {
		for (int i = 0; i < 10; i++) {
			Product product = Product.builder().pname("상품" + i).price(100 * i)
					.delFlag(false).pdesc("상품 설명입니다." + i).build();
			product.addImageString(UUID.randomUUID().toString() + "_" + "image1.jpg");
			product.addImageString(UUID.randomUUID().toString() + "_" + "image2.jpg");
			productRepository.save(product);
		}
	}

	// @Transactional
	// @Test
	public void testRead() {
		Long pno = 1L;
		Optional<Product> result = productRepository.findById(pno);
		Product product = result.orElseThrow();
		log.info(product); // ---------------- 1
		log.info(product.getImageList()); // --------------------------------- 2
	}

	// @Test
	public void testRead2() {
		Long pno = 1L;
		Optional<Product> result = productRepository.selectOne(pno);
		Product product = result.orElseThrow();
		log.info(product);
		log.info(product.getImageList());
	}

	// 상품 정보 삭제
	// @Commit
	// @Transactional
	// @Test
	public void testDelete() {
		Long pno = 2L;
		// productRepository.updateToDelete(pno, true);
	}

	// @Test
	public void testUpdate() {
		Long pno = 10L;
		Product product = productRepository.selectOne(pno).get();
		product.changeName("10번 상품");
		product.changeDesc("10번 상품 설명입니다.");
		product.changePrice(5000);
		// 첨부파일 수정 이미지 리스트 파일명을 클리어 하게 되면 save(product) 기존에 파일 이름 모두 삭제 진행
		product.clearList();
		product.addImageString(UUID.randomUUID().toString() + "-" + "NEWIMAGE1.jpg");
		product.addImageString(UUID.randomUUID().toString() + "-" + "NEWIMAGE2.jpg");
		product.addImageString(UUID.randomUUID().toString() + "-" + "NEWIMAGE3.jpg");
		productRepository.save(product);
	}

	// 상품 정보 페이징 기법(상품 정보 리스트)
	// 조인을 통해서 Object[0] product와 Object[1] productImage
	// result 속에서 paging 정보가 모두 들어있음
	// @Test
	public void testList() {
		// org.springframework.data.domain 패키지
		Pageable pageable = PageRequest.of(0, 10, Sort.by("pno").descending());
		Page<Object[]> result = productRepository.selectList(pageable);
		// java.util
		result.getContent().forEach(arr -> log.info(Arrays.toString(arr)));
	}

	// @Test
	public void testList2() {
		// 1 page, 10 size
		PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
		PageResponseDTO<ProductDTO> result = productService.getList(pageRequestDTO);
		result.getDtoList().forEach(dto -> log.info(dto));
	}

	@Test
	public void testRegister() {
		ProductDTO productDTO = ProductDTO.builder()
				.pname("새로운 상품")
				.pdesc("신규 추가 상품입니다.")
				.price(1000)
				.build();
		// uuid가 있어야함
		productDTO.setUploadFileNames(
				java.util.List.of(UUID.randomUUID() + "_" + "Test1.jpg", UUID.randomUUID()
						+ "_" + "Test2.jpg"));
		productService.register(productDTO);
	}

	@Test
	public void testRead3() {
		// 실제 존재하는 번호로 테스트(DB에서 확인)
		Long pno = 9L;
		ProductDTO productDTO = productService.get(pno);
		log.info(productDTO);
		log.info(productDTO.getUploadFileNames());
	}
}
