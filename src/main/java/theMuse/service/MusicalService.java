package theMuse.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import theMuse.dto.MusicalDto;

public interface MusicalService {
	
	// 뮤지컬 정보 목록 조회 	
	public int MusicalListCount() throws Exception;
	
    // 검색 조건과 일치하는 제품 중 offset부터 8개를 조회하여 반납하는 기능
	public List<MusicalDto> selectMusicalList() throws Exception;
	
	// 관리자 : 뮤지컬 정보 등록
	// 뮤지컬 정보 이미지 저장
	public int insertMusicalInfo(MusicalDto musicalDto) throws Exception;
	String saveFile(MultipartFile file) throws Exception;

	// 관리자 : 뮤지컬 정보 상세 조회
	public MusicalDto selectMusicalDetail(int musicalIdx) throws Exception;
	
	// 관리자 : 뮤지컬 정보 수정
	public int updateMusicalInfo(MusicalDto musicalDto) throws Exception;
	
	// 관리자 : 뮤지컬 정보 삭제
	public int deleteMusicalInfo(int musicalIdx) throws Exception;
	
	// 좋아요 수 업데이트 기능
	public void updateLikesCount(int musicalIdx) throws Exception;
}
