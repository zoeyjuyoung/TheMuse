package theMuse.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import theMuse.dto.MusicalDto;
import theMuse.service.MusicalService;

@Slf4j
@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
public class MusicalController {

	@Autowired
	private MusicalService musicalService;
	
	
	
	//Todo 뮤지컬 정보 목록 조회 & 페이징
	@GetMapping("/themuse/musicallist")
	public ResponseEntity<List<MusicalDto>> openMusicalList() throws Exception {
		List<MusicalDto> list = musicalService.selectMusicalList();
		
		if(list != null && list.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	// 사용자 : 뮤지컬 정보 상세 조회
	@GetMapping("/themuse/musicaldetail/{musicalIdx}")
	public ResponseEntity<MusicalDto> openBoardDetail(@PathVariable("musicalIdx") int musicalIdx) throws Exception {
		MusicalDto musicalDto = musicalService.selectMusicalDetail(musicalIdx);
		if (musicalDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(musicalDto);
		}
	}
	
	//관리자용 뮤지컬 정보 목록 조회 & 페이징
		@GetMapping("/themuse/admin/musicallist")
		public ResponseEntity<List<MusicalDto>> openAdminMusicalList() throws Exception {
			List<MusicalDto> list = musicalService.selectMusicalList();
			
			if(list != null && list.size() > 0) {
				return ResponseEntity.status(HttpStatus.OK).body(list);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}
		}
		
	// 관리자 : 뮤지컬 정보 등록
	@PostMapping("/themuse/admin/insertmusical")
	public ResponseEntity<Map<String, Object>> insertMusical(@RequestBody MusicalDto musicalDto) throws Exception{
	int insertedCount = 0;
	try {
		insertedCount = musicalService.insertMusicalInfo(musicalDto);
		if (insertedCount > 0) {
			Map<String, Object> result = new HashMap<>();
			result.put("message", "정상적으로 등록되었습니다.");
			result.put("count", insertedCount);
			result.put("musicalIdx", musicalDto.getMusicalIdx());		
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} else {
			Map<String, Object> result = new HashMap<>();
			result.put("message", "등록된 내용이 없습니다.");
			result.put("count", insertedCount);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}
	} catch (Exception e) {
		Map<String, Object> result = new HashMap<>();
		System.out.println(e);
		result.put("message", "등록 중 오류가 발생했습니다.");
		result.put("count", insertedCount);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
		}
	}
		
	// Todo 뮤지컬 정보 이미지 저장
	@GetMapping("/themuse/download.do")
	public void downloadFile(@RequestParam int musicalIdx, HttpServletResponse response) throws Exception {
	
		MusicalDto musicalDto = musicalService.selectMusicalDetail(musicalIdx);
				
		String musicalImg = musicalDto.getMusicalImg();
		
		// reviewImage를 읽어서 전달
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			response.setHeader("Content-Disposition", "inline;");
			
			byte[] buf = new byte[1024];
			fis = new FileInputStream(musicalImg);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(response.  getOutputStream());
			int read;
			while((read = bis.read(buf, 0, 1024)) != -1) {
				bos.write(buf, 0, read);
			}
		} finally {
			bos.close();
			bis.close();
			fis.close();
		}
		
	}

	
	// 관리자 : 뮤지컬 정보 수정
	@PutMapping("/themuse/admin/updateinfo/{musicalIdx}")
	public ResponseEntity<Integer> updateMusical(@PathVariable("musicalIdx") int musicalIdx, @RequestBody MusicalDto musicalDto) throws Exception {
		musicalDto.setMusicalIdx(musicalIdx);
		int updatedCount = musicalService.updateMusicalInfo(musicalDto);
		if (updatedCount != 1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(updatedCount);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(updatedCount);
		}
	}
	
	// 관리자 : 뮤지컬 정보 삭제
	@DeleteMapping("/themuse/admin/deleteinfo/{musicalIdx}")
	public ResponseEntity<Integer> deleteMusical(@PathVariable("musicalIdx") int musicalIdx) throws Exception {
		int deletedCount = musicalService.deleteMusicalInfo(musicalIdx);
		if (deletedCount != 1) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(deletedCount);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(deletedCount);
		}
	}
	
	// Todo 좋아요 수 업데이트 기능
	
}
