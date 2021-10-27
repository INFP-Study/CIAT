import React from 'react';
import { Layout } from 'antd';
import { Content } from 'antd/lib/layout/layout';
import SiteHeader from './header';
import SiteFooter from './footer';
import Nav from './nav';
import styled from 'styled-components';
import Category from './category';
import { FEED_URL } from '../../../constants/urls';
import { theme } from '../../../style/theme';

const LayoutAntd = styled(Layout)`
  display: flex;
  flex-direction: row;
`;

const ContentAntd = styled(Content)`
  margin: 24px 16px 0px;
`;
const ContentInner = styled.div`
  padding: 24px;
  min-height: 80vh;
  background: ${theme.colorWhite};
  font-size: ${theme.fontSizeBody02};
  font-family: ${theme.fontBasic};
`;

function SiteLayout({ children }) {
  return (
    <LayoutAntd>
      <Layout style={{ minHeight: '100vh', flexDirection: 'row' }}>
        <Nav />
        {location.pathname.includes(FEED_URL) && <Category />}
      </Layout>
      <Layout style={{ background: theme.colorWhite, width: '100%' }}>
        <SiteHeader />
        <ContentAntd>
          <ContentInner>{children}</ContentInner>
        </ContentAntd>
        <SiteFooter />
      </Layout>
    </LayoutAntd>
  );
}

export default SiteLayout;
