import React, { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Layout } from 'antd';
import { Content } from 'antd/lib/layout/layout';
import SiteHeader from './header';
import SiteFooter from './footer';
import Nav from './nav';
import styled from 'styled-components';
import { FEED_DETAIL_URL } from '../../../constants/urls';
import { theme } from '../../../style/theme';
import { getMenuList } from '../../../store/menu';
import { useLocation } from 'react-router';

const LayoutAntd = styled(Layout)`
  display: flex;
  flex-direction: row;
`;

const ContentAntd = styled(Content)`
  margin: 24px 16px 0px;
`;
const ContentInner = styled.div`
  padding: 24px;
  min-height: 100%;
  height: 100%;
  background: ${theme.colorWhite};
  font-size: ${theme.fontSizeBody02};
  font-family: ${theme.fontBasic};
`;

function SiteLayout({ children }) {
  const dispatch = useDispatch();
  const [menuList, setMenuList] = useState([]);
  const [isMenu, setIsMenu] = useState(false);

  //메뉴 리스트 가져오기
  useEffect(() => {
    dispatch({ type: getMenuList.type });
  }, []);

  const menu = useSelector((state) => state.menu.menuList);

  useEffect(() => {
    setMenuList(menu);
    setIsMenu(true);
  }, [menu]);

  const location = useLocation();

  return (
    <LayoutAntd>
      <Layout style={{ minHeight: '100vh', flexDirection: 'row' }}>
        {isMenu && <Nav menuList={menuList} location={location} />}
      </Layout>
      <Layout style={{ background: theme.colorWhite, width: '100%' }}>
        <SiteHeader />
        <ContentAntd>
          <ContentInner>{children}</ContentInner>
        </ContentAntd>
        <SiteFooter location={location} />
      </Layout>
    </LayoutAntd>
  );
}

export default SiteLayout;
