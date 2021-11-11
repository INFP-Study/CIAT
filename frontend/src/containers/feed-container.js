import React from 'react';
import { Space } from 'antd';
import styled from 'styled-components';
import PostWrite from '../components/feed/post-write';
import Post from '../components/feed/post';

const contentsTmp = [
  {
    id: 12,
    title: '테스트',
    author: '김이김',
    date: '08월 21일',
    content:
      '1간결함과 안정감이 돋보이는 내부 인테리어와 한글을 연상시키는 탁자 또한 매력적일 터. 도심 속 고즈넉한 숙소를 찾아 헤맨다면, 서촌에 위치한 ‘SIDE’에서 일상을 마무리하는 것도 좋을 듯하다.',
    src: [],
    like: 21,
    comment: 12,
  },
  {
    id: 0,
    title: '테스트',
    author: '김김김',
    date: '08월 21일',
    content: '제 식물 어떤가요?',
    src: [
      'https://images.unsplash.com/photo-1501004318641-b39e6451bec6?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1073&q=80',
    ],
    like: 21,
    comment: 12,
  },
  {
    id: 1,
    title: '테스트',
    author: '이이이',
    date: '10월 11일',
    content: '바다 갔을 때..',
    src: [
      'https://images.unsplash.com/photo-1487009805257-5ed2eb9f10a3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2074&q=80',
      'https://images.unsplash.com/photo-1610839563044-8996a168a961?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80',
    ],
    like: 3,
    comment: 3,
  },
  {
    id: 2,
    title: '테스트',
    author: '홍홍홍',
    date: '12월 03일',
    content: '그냥 사진 모음',
    src: [
      'https://images.unsplash.com/photo-1619463284209-1215aeda42c8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=687&q=80',
      'https://images.unsplash.com/photo-1542376674-999e4bd24f6b?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=735&q=80',
      'https://images.unsplash.com/photo-1542446633-362158ea0052?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1633&q=80',
      'https://images.unsplash.com/photo-1615506236937-446d39d6cbce?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1974&q=80',
    ],
    like: 1,
    comment: 5,
  },
  {
    id: 3,
    title: '테스트',
    author: '최최최',
    date: '03월 03일',
    content: 'text',
    src: [
      'https://images.unsplash.com/photo-1619463284209-1215aeda42c8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=687&q=80',
      'https://images.unsplash.com/photo-1542376674-999e4bd24f6b?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=735&q=80',
      'https://images.unsplash.com/photo-1542446633-362158ea0052?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1633&q=80',
    ],
    like: 1,
    comment: 5,
  },
];

function FeedContainer() {
  const Wrapper = styled.div`
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
  `;

  return (
    <Wrapper>
      <Space direction="vertical" size="middle">
        <PostWrite />
        <Post contents={contentsTmp} />
      </Space>
    </Wrapper>
  );
}

export default FeedContainer;
