package com.Board.domain.post;

import com.Board.common.dto.SearchDto;
import com.Board.paging.Pagination;
import com.Board.paging.PagingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    // 게시글 저장
    @Transactional
    public Long savePost(final PostRequest params) {
        postMapper.save(params);
        return params.getId();
    }

    // 게시글 상세정보 조회
    public PostResponse findPostById(final Long id) {
        return postMapper.findById(id);
    }

    // 게시글 수정
    @Transactional
    public Long updatePost(final PostRequest params) {
        postMapper.update(params);
        return params.getId();
    }

    // 게시글 삭제
    public Long deletePost(final Long id) {
        postMapper.deleteById(id);
        return id;
    }

    // 게시글 목록 조회
    public PagingResponse<PostResponse> findAllPost(final SearchDto params) {

        int count = postMapper.count(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        List<PostResponse> list = postMapper.findAll(params);
        return new PagingResponse<>(list, pagination);
    }



    // 게시글 조회수 조회
    public void viewCount(Long id){
        postMapper.viewCount(id);

    }


}
