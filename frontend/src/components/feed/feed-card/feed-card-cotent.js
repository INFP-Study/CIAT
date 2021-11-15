import React from 'react';
import { Space } from 'antd';
import FeedTop from './feed-card-top';
import FeedBottom from './feed-card-bottom';
import { Link } from 'react-router-dom';

function FeedCotent({ id, content, author, date, comment, src, like }) {
  return (
    <Space direction="vertical" size="small" style={{ width: '100%' }}>
      <FeedTop author={author} date={date} />
      <div
        style={{
          marginLeft: 76,
          marginRight: 76,
        }}
      >
        {content}
      </div>
      {src.length === 1 ? (
        <img width={642} height={642} src={src} />
      ) : (
        src.map((src, i) => (
          <Space size={2} wrap key={i}>
            <Link to={`/feed/${id}`}>
              <img width={320} height={320} src={src} />
            </Link>
          </Space>
        ))
      )}
      <FeedBottom like={like} comment={comment} />
    </Space>
  );
}

export default FeedCotent;
