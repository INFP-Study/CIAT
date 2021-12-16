import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import FeedDetailSlide from '../components/feed-detail/feed-detail-slide';
import FeedDetailComments from '../components/feed-detail/feed-detail-comments';

const content = {
  id: 12,
  title: '테스트',
  author: '김이김',
  date: '08월 21일',
  content:
    '1간결함과 안정감이 돋보이는 내부 인테리어와 한글을 연상시키는 탁자 또한 매력적일 터. 도심 속 고즈넉한 숙소를 찾아 헤맨다면, 서촌에 위치한 ‘SIDE’에서 일상을 마무리하는 것도 좋을 듯하다.',
  src: [
    'https://images.unsplash.com/photo-1619463284209-1215aeda42c8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=687&q=80',
    'https://images.unsplash.com/photo-1542376674-999e4bd24f6b?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=735&q=80',
    'https://images.unsplash.com/photo-1542446633-362158ea0052?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1633&q=80',
    'https://images.unsplash.com/photo-1615506236937-446d39d6cbce?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1974&q=80',
  ],
  like: [],
  comments: [
    {
      id: 2,
      author: '홍길동',
      comment: '반가워요 사진 좋네요 ',
      regDate: '2일전',
    },
    {
      id: 3,
      author: '홍길동',
      comment: '반가워요 사진 좋네요 ',
      regDate: '2일전',
    },
    {
      id: 4,
      author: '홍길동',
      comment: '반가워요 사진 좋네요 ',
      regDate: '2일전',
    },
    {
      id: 5,
      author: '홍길동',
      comment: '반가워요 사진 좋네요 ',
      regDate: '2일전',
    },
  ],
};

const Wrapper = styled.div`
  display: flex;
  flex-flow: row;
  align-items: stretch;
  height: calc(100vh - 70px);
  max-height: calc(100vh - 70px);
  margin: -48px -40px -24px;
`;

function FeedDetailContainer() {
  const [images, setImages] = useState([]);

  useEffect(() => {
    getImg(content);
  }, []);

  const getImg = (content) => {
    content.src.map((src) => setImages((images) => [...images, src]));
  };

  return (
    <Wrapper>
      <FeedDetailSlide images={images} />
      <FeedDetailComments content={content} />
    </Wrapper>
  );
}

export default FeedDetailContainer;
