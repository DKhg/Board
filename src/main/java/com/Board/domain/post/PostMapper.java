package com.Board.domain.post;

import com.Board.common.dto.SearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    // 게시글 저장
    void save(PostRequest params);

    // 게시글 상세 조회
    PostResponse findById(Long id);

    // 게시글 수정
    void update(PostRequest params);

    // 게시글 삭제
    void deleteById(Long id);

    // 게시글 리스트 조회
    List<PostResponse> findAll(SearchDto params);

    // 게시글 카운팅
    int count(SearchDto params);

    // 조회수 카운팅
    void viewCount(Long id);


}
