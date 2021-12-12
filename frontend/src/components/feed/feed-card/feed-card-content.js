import React from 'react';
import { Space } from 'antd';
import FeedTop from './feed-card-top';
import FeedBottom from './feed-card-bottom';
import { Link } from 'react-router-dom';
import { FEED_DETAIL_URL, FEED_URL } from '../../../constants/urls';

function FeedCotent({ id, content, author, date, comment, src, like, isLike }) {
  return (
    <Space direction="vertical" size="small" style={{ width: '100%' }}>
      <div style={{ paddingLeft: '16px', paddingRight: '16px' }}>
        <FeedTop author={author} date={date} />
      </div>
      <div
        style={{
          marginLeft: 76,
          marginRight: 76,
        }}
      >
        {content}
      </div>
      {src.length === 1 ? (
        <Link to={`${FEED_DETAIL_URL}/${id}`}>
          <img width={642} height={642} src={src} />
        </Link>
      ) : (
        <Space size={2} wrap>
          {src.map((src, i) => (
            <Link to={`${FEED_DETAIL_URL}/${id}`} key={i}>
              <img width={319} height={320} src={src} />
            </Link>
          ))}
        </Space>
      )}
      <div
        style={{
          paddingLeft: '26px',
          paddingRight: '26px',
        }}
      >
        <FeedBottom like={like} isLike={isLike} comment={comment} />
      </div>
    </Space>
  );
}

export default FeedCotent;
